package com.oracle.demo1;

public class Operator {

	//定义一个Input类型的属性
	private Input in;
	//定义一个布尔类型的属性，控制循环是否继续
	private boolean flag;
	//定义一个FileOperator类型的对象
	private FileOperator fileOperator;
	public Operator(){
		in = new Input();
		flag=true;
		fileOperator = new FileOperator();
	}
	//编写一个方法，用来执行相关的操作
	public void operator(){
		//编写一个循环控制菜单的重复显示
		while(flag){
			//调用菜单的显示的方法
			Menu.show();
			//让用户进行选择
			int n = in.getInt("请选择您要执行的操作:", "您输入的选项的格式不正确,选项应该是一个正整数");
			switch (n) {
			case 1:
				//获取用户输入的人员名称
				String name = in.getString("请输入人员的姓名:");
				//获取用户输入的人员的年龄
				int age = in.getAge("请输入人员的年龄:", "年龄的格式不正确,年龄只能是1位或2位正整数");
				Person[] pers = fileOperator.readPersons();
				Person per = new Person(name,age);
				
				if(pers!=null){
					if(pers.length==0){
						pers = new Person[1];
						pers[0] = per;
					}else{
						Person[] newPers = new Person[pers.length+1];
						for(int i=0;i<pers.length;i++){
							newPers[i] = pers[i];
						}
						newPers[newPers.length-1] = per;
						pers = newPers;
					}
				}else{
					pers = new Person[1];
					pers[0] = per;
				}
				fileOperator.writePersons(pers);
				break;
			case 2:
				Person[] pers2 = fileOperator.readPersons();
				if(pers2!=null){
					if(pers2.length==0){
						System.out.println("无数据");
					}else{
						for(Person p:pers2){
							System.out.println(p);
						}
						int id = in.getInt("请输入您要删除的人员的编号:", "编号的格式不正确,格式应该是正整数");
						//编写一个变量代表要删除的编号的人员在数组中的下标
						int index2 = -1;
						for(int i=0;i<pers2.length;i++){
							if(pers2[i].getId()==id){
								index2=i;
								break;
							}
						}
						if(index2==-1){
							System.out.println("要删除的人员不存在");
						}else{
							//新建一个新数组
							Person[] newPers1 = new Person[pers2.length-1];
							int newPers1Index=0;
							//编写一个循环遍历源数组
							for(int i=0;i<pers2.length;i++){
								if(i!=index2){
									newPers1[newPers1Index] = pers2[i];
									newPers1Index++;
								}
							}
							pers2 = newPers1;
							fileOperator.writePersons(pers2);
						}
						
						
					}
				}else{
					System.out.println("无数据");
				}
				break;
			case 3:
				Person[] pers3 = fileOperator.readPersons();
				if(pers3!=null){
					if(pers3.length==0){
						System.out.println("无数据");
					}else{
						for(Person p:pers3){
							System.out.println(p);
						}
						int id = in.getInt("请输入您要修改的人员的编号:", "编号的格式不正确,格式应该是正整数");
						int index3 = -1;
						for(int i=0;i<pers3.length;i++){
							if(pers3[i].getId()==id){
								index3=i;
								break;
							}
						}
						if(index3==-1){
							System.out.println("没有此人员");
						}else{
							String name3 = in.getString("请输入要修改的姓名:");
							//获取用户输入的人员的年龄
							int age3 = in.getAge("请输入要修改的年龄:", "年龄的格式不正确,年龄只能是1位或2位正整数");
							//从数组中将要修改的人员取出
							Person p = pers3[index3];
							p.setName(name3);
							p.setAge(age3);
							fileOperator.writePersons(pers3);
						}
						
						
					}
				}else{
					System.out.println("无数据");
				}
				break;
			case 4:
				Person[] pers1 = fileOperator.readPersons();
				if(pers1!=null){
					if(pers1.length==0){
						System.out.println("当前没有数据");
					}else{
						for(Person per1:pers1){
							System.out.println(per1);
						}
					}
				}
				break;
			case 5:
				System.out.println("程序退出");
				flag=false;
				System.exit(1);
				break;

			default:
				System.out.println("没有这个选项");
				break;
			}
		}
		
	}
}
