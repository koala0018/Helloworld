
public class Operator {

	private Input input = null;
	public Operator(){
		input = new Input();
	}
	public void operator(){
		//����һ����������ѭ��ִ�е�����
		boolean flag=true;
		//��дһ��ѭ����������ʾ�˵��Լ���ȡ�û��������Ϣ�������û��������Ϣ�ж�ִ����һ�����ܣ�����û������ѡ��������ظ���ʾ�˵�
		while(flag){
			//��ʾ�˵�
			Menu.showMenu();
			//��ȡ�û������ѡ��
			int n = input.getInt("��ѡ����Ҫִ�еĲ���:");
			//�����û�����������ж�ִ��ĳһ���
			switch (n) {
				case 1://�û�ѡ��ִ�е�¼
					//����һ���������������û���������Ĵ���
					int count=3;
					//��дһ���������������û������Լ���ѭ��������
					boolean f1 = true;
					while(f1){
						if(count<=0){
							System.out.println("������������3�δ��󣬳������");
							f1=false;
							flag=false;
							break;
						}
						
						String username = input.getString("�������û���:");
							
						String password = input.getString("����������:");
						//�ж��û����������Ƿ���ȷ
						if(username.equals("admin")&&password.equals("admin")){
							System.out.println("��ӭadminʹ�����ǵ�XXXϵͳ");
							flag=false;
							f1=false;
						}else{
							System.out.println("�û������������");		
							count--;
						}
							
					}
						
					break;
				case 2://�û�ѡ���˳�
					System.out.println("����ִ�н��������˳�");
					flag=false;
					break;

				default://�û�������û�е�ѡ��
					System.out.println("��ǰû�����ѡ��");
					break;
				}
					
			}
				
	}
}
