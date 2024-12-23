package control;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
	/**
	 * 这个类用于列出指定目录中的文件，并根据用户输入进行过滤和排序。
	 * 
	 * @author 71123138王磊
	 */
public class DirLister {
	/**
	 * 路径名称。
	 */
	private File path;
	/**
	 * 提供的路径下的所有文件。
	 */
	private File[] files;
	/**
	 * 用于过滤的后缀名。
	 */
	private String suffix;
	/**
	 * 用于存储过滤和排序的文件数组。
	 */
	private List<File> filteredFiles = new ArrayList<>();
	/**
	 * 用于表示路径是否存在。
	 */
	private Boolean pathexist=true;
	/**
	 * 创建一个新的文件目录工具，同时还会判断提供的路径是否存在。
	 * 
	 * @param path 用户提供的文件路径
	 */
	public DirLister(String path) {
		this.path=new File(path);
		if (!this.path.exists() || !this.path.isDirectory()) {
			pathexist=false;
        }
	}
	/**
	 * 设置后缀名。
	 * 
	 * @param suffix 用户提供的后缀名
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * 获取路径下的所有文件
	 */
	public void getfiles() {
		
		files = path.listFiles();
	}
	/**
	 * 过滤出对应后缀名的文件
	 */
	public void sortfiles() {
        for (File file : files) {
            if (file.isFile() && file.getName().matches(suffix)) {
                filteredFiles.add(file);
            }
        }
	}
	/**
	 * 根据用户需求进行排序
	 * 
	 * @param ordermanner 用户选择的事件排序方式
	 */
	public void orderfiles(String ordermanner) {
		if ("asc".equals(ordermanner)) {
            Collections.sort(filteredFiles, Comparator.comparing(File::lastModified));
        } else if ("desc".equals(ordermanner)) {
            Collections.sort(filteredFiles, Comparator.comparing(File::lastModified).reversed());
        } else {
            System.out.println("无效的排序方式。");
            return;
        }
	}
	/**
	 * 打印过滤排序后的文件列表
	 */
	public void display() {
		for (File file : filteredFiles) {
            System.out.println(file.getName() + " - 最后修改时间: " + new java.util.Date(file.lastModified()));
        }
	}
	/**
	 * 获取文件路径是否存在
	 * 
	 * @return pathexist 路径是否存在
	 */
	public Boolean getpathexist() {
		return pathexist;
	}
	
	
	

}
