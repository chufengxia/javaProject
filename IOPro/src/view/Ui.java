package view;

import java.util.Scanner;

import control.DirLister;
/**
 * 这个类用于控制Ui界面
 * 
 * @author 71123138王磊
 */
public class Ui {
	/**
	 * 用于获取用户输入内容
	 */
	private Scanner scanner;
	/**
	 * 用户输入的路径名
	 */
	private String path;
	/**
	 * 用户输入的后缀名
	 */
	private String suffix;
	/**
	 * 用户输入的排序方式
	 */
	private String ordermanner;
	/**
	 * 创建一个新的Ui对象
	 */
	public Ui() {
		scanner=new Scanner(System.in);
	}
	/**
	 * 展示Ui界面，并与用户交互
	 */
	public void show() {
		while(true) {
			System.out.println("请输入目录路径：");
			path=scanner.nextLine();
			
	        DirLister dirLister=new DirLister(path);
	        if (!dirLister.getpathexist()) {
	            System.out.println("目录不存在或不是有效的目录。");
	        }
	        else {
	        	System.out.println("请输入文件后缀名：");
		        suffix= ".*\\." + scanner.nextLine();
		        while(true) {
			        System.out.println("请输入排序方式（asc 表示升序，desc 表示降序）：");
			        ordermanner = scanner.nextLine();
			        if("asc".equals(ordermanner)||"desc".equals(ordermanner)) {
			        	break;
			        }
			        System.out.println("输入有错，请重新输入");
			    }
		        dirLister.setSuffix(suffix);
	        	dirLister.getfiles();
				dirLister.sortfiles();
				dirLister.orderfiles(ordermanner);
				dirLister.display();
	        }
	        			
	        System.out.println("输入continue继续，输入close结束");
	        if(!"continue".equals(scanner.nextLine())) {
	        	return;
	        }
		}
		
	}
	
}
