package com.hpe.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hpe.po.Asset;
import com.hpe.po.Bank;
import com.hpe.po.User;
import com.hpe.service.IAssetService;
import com.hpe.service.IBankService;
import com.hpe.service.IUserService;
import com.hpe.service.impl.AssetServiceImpl;
import com.hpe.service.impl.BankServiceImpl;
import com.hpe.service.impl.UserServiceImpl;
import com.hpe.vo.AssetInfo;

/**
 * @Description:实现用户界面的类
 * @author chaoling
 * @date 2018年8月2日
 */
public class UserUI {
	
	//创建需要的业务类对象和实体类，并将其私有化为属性
	Scanner sc = new Scanner(System.in);
	private static User user = new User();
	private IUserService userService = new UserServiceImpl();
	private IAssetService assetServie = new AssetServiceImpl();
	private IBankService bankService = new BankServiceImpl();

	/**
	 * @Description: user界面入口函数
	 */
	public void user() {

		System.out.println("************** 用户界面*************");
		System.out.println("************** 1. 登录 *************");
		System.out.println("************** 2. 注册 *************");
		System.out.println("请选择");
		// 获取选择
		String chioce = sc.nextLine();

		// 判断用户输入 注册/登录
		if (chioce.equals("1")) {
			// 给user赋值，为以后的函数提供userId
			login();
			// 如果user== null 表示不允许登录，即密码与用户名不匹配
			if (user == null)
				return;

		} else if (chioce.equals("2")) {
			// 注册
			register();
			return;
		} else {
			// 输入非法处理
			System.out.println("选择错误");
			return;
		}

		// 循环
		while (true) {

			// 显示主界面
			menu();
			// 获取选择
			chioce = sc.nextLine();

			switch (chioce) {
			case "1":
				// 查询全部资产
				selectAsset();
				break;
			case "2":
				// 添加资产
				addAsset();
				break;
			case "3":
				// 提取/存入
				takeAndSave();
				break;
			case "4":
				// 查看总资产
				selectAllAsset();
				break;
			case "5":
				// 修改密码
				updatePassword();
				break;
			case "6":
				// 返回主菜单
				System.out.println("谢谢使用");
				return;
			default:
				// 输入非法处理
				System.out.println("选择错误");
				break;
			}
		}
	}

	/**
	 * @Description: 实现登录功能
	 */
	private void login() {

		System.out.println("请输入用户名");
		String userName = sc.nextLine();
		System.out.println("请输入密码");
		String userPassword = sc.nextLine();

		// 给user赋值
		user = new User(0, userName, userPassword, null, null, null, null, null);
		// 获取userId，用于判断
		user = userService.login(user);
		// 判断，对不同的返回值，做出不同的输出
		if (user == null) {
			// 如果是-1表示用户名不存在，结束函数
			System.out.println("用户名不存在");
			return;
		} 
	}

	/**
	 * @Description: 实现注册功能
	 */
	private void register() {

		// 获取输入
		System.out.println("请输入用户名");
		String userName = sc.nextLine();
		System.out.println("请输入密码");
		String userPassword = sc.nextLine();
		System.out.println("请输入真实姓名");
		String realName = sc.nextLine();
		System.out.println("请输入性别");
		String sex = sc.nextLine();
		System.out.println("请输入电话号码");
		String tel = sc.nextLine();
		System.out.println("请输入身份证号");
		String idCard = sc.nextLine();
		System.out.println("请输入联系地址");
		String address = sc.nextLine();
		// 将所有的输入封装成一个对象
		user = new User(0, userName, userPassword, realName, sex, tel, idCard, address);
		// 获取返回值，用于判断
		int res = userService.regist(user);
		// 判断，对不同的情况进行不同的输出显示
		if (res == -1)
			// res == -1 用户名已存在
			System.out.println("该用户名已存在");
		else if (res == 0)
			// res == 0 注册失败
			System.out.println("注册失败");
		else
			// res == 1 注册成功
			System.out.println("注册成功");
	}

	/**
	 * @Description: 显示主界面
	 */
	private void menu() {

		// 输出主界面
		System.out.println("------------个人资产管理系统------------");
		System.out.println("******[欢迎您，用户-" + user.getUserName() + "]*******");
		System.out.println("1.查看资产\t2.添加新资产\t3.存取资产\t4.查看总资产\t5.修改密码\t6.返回登录主菜单");
		System.out.println("------------个人资产管理系统------------");
		System.out.println("请选择业务");

	}

	/**
	 * @Description: 查看所有资产
	 */
	private void selectAsset() {

		System.out.println("------------查看所有资产------------");
		// 获取返回值
		List<AssetInfo> assets = assetServie.selectAssetsByUserId(user.getUserId());
		// 判断，若为null说明不存在记录
		if (assets == null) {
			System.out.println("暂无记录");
			return;
		}
		// 若不为null,遍历输出
		for (AssetInfo asset : assets)
			System.out.println(asset);

	}

	/**
	 * @Description:实现添加资产的功能
	 */
	private void addAsset() {

		System.out.println("------------添加新资产------------");
		// 获取所有的银行记录
		List<Bank> banks = bankService.selectAllBank();
		// 为null说明无银行，即不能添加新资产
		if (banks == null) {
			System.out.println("暂无银行");
			return;
		}
		// 不为null遍历输出所有的银行记录
		for (Bank bank : banks)
			System.out.println(bank);

		// 获取添加新资产的信息
		System.out.println("请输入银行id");
		String strBankId = sc.nextLine();
		int bankId = Integer.parseInt(strBankId);
		System.out.println("请输入卡号");
		String cardNum = sc.nextLine();
		System.out.println("请输入金额");
		double cardMoney = sc.nextDouble();
		sc.nextLine();
		// 将信息封装成对象
		Asset asset = new Asset(bankId, cardNum, cardMoney, new Date(), user.getUserId());
		// 获取返回值
		int res = assetServie.addAsset(asset);
		// 对返回值的不同结果做不同的输出
		if (res == -1)
			// res == -1 银行不存在
			System.out.println("该银行不存在");
		else if (res == 2)
			// res == 2 银行已存在，但是已存在同卡号
			System.out.println("该银行已存在该卡号");
		else if (res == 1)
			// res == 1添加成功
			System.out.println("添加新资产成功");
		else
			// res == 0 添加失败
			System.out.println("添加新资产失败");

	}

	/**
	 * @Description: 存取资产操作
	 */
	private void takeAndSave() {

		System.out.println("------------存取资产------------");
		System.out.println("请输入存入或者提取资产， 1/提取 2/存入");
		// 获取选择
		String chioce = sc.nextLine();
		// 对不同的输入，做不同的相应
		if (chioce.equals("1"))
			// 提取资产
			take();
		else if (chioce.equals("2"))
			// 存入资产
			save();
		else
			// 选择错误
			System.out.println("选择错误");

	}

	/**
	 * @Description: 提取资产页面显示
	 */
	private void take() {

		System.out.println("------------提取------------");
		System.out.println("您目前的资产如下");

		// 获取个人的全部资产
		List<AssetInfo> assets = assetServie.selectAssetsByUserId(user.getUserId());
		// 不为null 遍历输出
		if (assets != null)
			for (AssetInfo asset : assets)
				System.out.println(asset);

		// 获取提取资产的信息
		System.out.println("请输入银行Id");
		int bankId = sc.nextInt();
		sc.nextLine();
		System.out.println("请输入银行卡号");
		String cardNum = sc.nextLine();
		sc.nextLine();
		System.out.println("请输入提取金额");
		double cardMoney = sc.nextDouble();
		sc.nextLine();

		// 封装成对象
		Asset asset = new Asset(bankId, cardNum, cardMoney, null, user.getUserId());
		// 接受返回值
		int res = assetServie.extractAsset(asset);
		// 对返回值处理
		if (res == -1)
			// 资产不存在
			System.out.println("您并不存在此资产");
		else if (res == 2)
			// 提取金额大于已有金额，即资产不足
			System.out.println("此资产不足");
		else if (res == 1)
			// 提取成功
			System.out.println("恭喜您，提取资产成功");
		else
			// 提取失败
			System.out.println("提取资产失败");
	}

	/**
	 * @Description: 存入资产显示
	 */
	private void save() {

		System.out.println("------------存入------------");
		System.out.println("您目前的资产如下");
		// 获取本人的所有资产
		List<AssetInfo> assets = assetServie.selectAssetsByUserId(user.getUserId());
		// 不为null 遍历输出
		if (assets != null)
			for (AssetInfo asset : assets)
				System.out.println(asset);

		// 获取存入信息
		System.out.println("请输入银行Id");
		int bankId = sc.nextInt();
		sc.nextLine();
		System.out.println("请输入银行卡号");
		String cardNum = sc.nextLine();
		sc.nextLine();
		System.out.println("请输入存入金额");
		double cardMoney = sc.nextDouble();
		sc.nextLine();
		// 封装
		Asset asset = new Asset(bankId, cardNum, cardMoney, null, user.getUserId());
		// 接受返回值
		int res = assetServie.depositAsset(asset);
		// 对不同返回值做出不同输出
		if (res == -1)
			System.out.println("您并不存在此资产");
		else if (res == 1)
			System.out.println("恭喜您，存入资产成功");
		else
			System.out.println("存入资产失败");
	}

	/**
	 * @Description: 查看总资产
	 */
	private void selectAllAsset() {

		System.out.println("------------查看总资产------------");
		// 获取总资产
		double sumAsset = assetServie.selectSumMoneyByUserId(user.getUserId());
		// 输出总资产
		System.out.println(user.getUserName() + ",您的总资产为:" + sumAsset);
	}

	/**
	 * @Description: 修改密码
	 */
	private void updatePassword() {

		// 获取信息
		System.out.println("请输入原密码");
		String oldUserPassword = sc.nextLine();
		System.out.println("请输入新密码");
		String newUserPassword = sc.nextLine();

		// 判断原密码是否输入正确
		if (!user.getUserPassword().equals(oldUserPassword))
			System.out.println("密码输入有误");
		else {
			// 对对象中的密码属性修改为新密码
			user.setUserPassword(newUserPassword);
			// 更新
			if (userService.changPwd(user))
				System.out.println("修改密码成功");
			else {
				// 更新失败，就当前user对象的密码修改为原密码
				System.out.println("修改密码失败");
				user.setUserPassword(oldUserPassword);
			}
		}
	}

}
