

import java.util.Scanner;

public class OrderingMsg2 {
	public static void main(String[] args) {
		//�������⣬һ�鶩����Ϣ
		String[] names=new String[4];
		String[] disMegs=new String[4];
		int[] times=new int[4];
		String[] addresses=new String[4];
		int[] states=new int[4];
		double[] sumPrices=new double[4];
		//��ʼ��2��������Ϣ
		names[0]="����";
		disMegs[0]="������˿ 1��";
		times[0]=12;
		addresses[0]="���·209��";
		states[0]=0;
		sumPrices[0]=24.0;
		names[1]="����";
		disMegs[1]="���մ��� 2��";
		times[1]=12;
		addresses[1]="���·209��";
		states[1]=1;
		sumPrices[1]=76.0;
		//�������壺һ���Ʒ��Ϣ
		String[] dishNames={"���մ���","������˿","ʱ���߲�"};
		double[] prices={38.0,18.0,10.0};
		int[] praiseNums=new int[3];
		Scanner input=new Scanner(System.in);
		int num=-1;
		do{
			System.out.println("***************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ɾ������");
			System.out.println("4��ǩ�ն���");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("��ѡ��");
			int choose=input.nextInt();
			boolean isAdd=false;
			switch(choose){
			case 1:
				//��Ҫ����
				System.out.println("******��Ҫ����*********");
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						isAdd=true;
						//��Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������\t");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"Ԫ";
							String praise=praiseNums[j]+"��";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						//�����Ʒ��źͷ���
						System.out.println("��ѡ��������Ʒ��ţ�");
						int chooseDish =input.nextInt();
						System.out.println("����������������");
						int number =input.nextInt();
						String dishMeg=dishNames[chooseDish-1]+" "+number;
						//���붩��������
						System.out.println("�����붩��������");
						String name=input.next();
						//�����Ͳ�ʱ��
						System.out.println("�������Ͳ�ʱ�䣨10-20֮���������");
						int time=input.nextInt();
						
						while(time<10||time>20){
							System.out.println("������������,������10-20֮�������");
							time=input.nextInt();
						}
						//�����Ͳ͵�ַ
						System.out.println("�������Ͳ͵�ַ");
						String address=input.next();
						
						//����ͷ�
						double sumPrice=prices[chooseDish-1]*number;
						//�Ͳͷѣ����ﵽ50Ԫʱ����6Ԫ�Ͳͷ�
						double deliCharge=sumPrice>50?0.0:6.0;
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ�");
						System.out.println("�������ǣ�"+dishMeg);
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						System.out.println("�Ͳ͵�ַ��"+address);
						System.out.println("�ͷѣ�"+sumPrice+",�Ͳͷ�"+deliCharge+"Ԫ");
						System.out.println("�ܽ�"+(sumPrice+deliCharge)+"Ԫ");
						
						//��������
						names[i]=name;
						disMegs[i]=dishMeg;
						times[i]=time;
						addresses[i]=address;
						sumPrices[i]=sumPrice+deliCharge;
						break;
					}
					
				}
				if(isAdd){
					System.out.println("�Բ������Ĳʹ��������޷�����");
				}
				break;
			case 2:
				//�鿴�ʹ���
				System.out.println("******�鿴�ʹ�");
				System.out.println("���\t������\t������Ʒ��Ϣ\t����ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬\t");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"��";
						
						String sumPrice=sumPrices[i]+"Ԫ";
						String state=states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+disMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
						
					}
				}
				break;
			case 3:
				//ɾ������
				System.out.println("������Ҫɾ���Ķ���");
				int id=input.nextInt();
				boolean find=false;
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&states[i]==0&&id==i+1){
						find=true;
						for(int j=i;j<names.length-1;j++){
							names[j]=names[j+1];
							disMegs[j]=disMegs[j+1];
							times[j]=times[j+1];
							addresses[j]=addresses[j+1];
							sumPrices[j]=sumPrices[j+1];
							states[j]=states[j+1];
						}
						names[names.length-1]=null;
						disMegs[names.length-1]=null;
						times[names.length-1]=0;
						addresses[names.length-1]=null;
						sumPrices[names.length-1]=0;
						states[names.length-1]=0;
					}else if(names[i]!=null&&states[i]==1&&id==i+1){
						find=true;
						System.out.println("�ö����Ѿ�ǩ�գ��޷�ɾ��");
					}
				}
				if(find=false){
					System.out.println("�˶���������");
				}
				break;
			case 4:
				//ǩ�ն���
				System.out.println("������Ҫǩ�յĶ�����ţ�");
				int signOrderId=input.nextInt();
				boolean isFind=false;
				for(int i =0;i<names.length;i++){
					if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
						System.out.println("�Բ�����ѡ��Ķ����Ѿ����ǩ�գ������ٴ�ǩ��");
						isFind=true;
						break;
					}else if(names[i]!=null&&states[i]==0&&signOrderId==i+1){
						states[i]=1;
						System.out.println("����ǩ�����");
						isFind=true;
					}
				}
				if(isFind==false){
					System.out.println("�˶���������");
				}
				
				break;
			case 5:
				//��Ҫ����
				
						//��Ʒ��Ϣ
				System.out.println("���\t��Ʒ��\t����\t������\t");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"Ԫ";
					String praise=praiseNums[j]+"��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				System.out.println("������Ҫ���޵Ķ�����ţ�");
				int zanId=input.nextInt();
				boolean zanFind=false;
				for(int i =0;i<dishNames.length;i++){
					if(dishNames[i]!=null&&zanId==i+1){
						zanFind=true;
						praiseNums[i]++;
						System.out.println("���޳ɹ�");
						break;
					}
				}
				if(zanFind==false){
					System.out.println("�˶���������");
				}
				break;
			case 6:
				//�˳�ϵͳ
				break;
			default:
				//�˳�ϵͳ
				break;
			
			}
			if(choose<1||choose>5){
				break;
			}else{
			//��ʾ����0����
			System.out.println("������0����");
			num=input.nextInt();
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι���");
	}
}
