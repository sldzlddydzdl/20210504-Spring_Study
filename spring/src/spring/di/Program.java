package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
//		Exam exam = new NewlecExam();
		// top -> down ���
		// Interface Exam �� ����� �̰��� ��ӹ��� NewlecExam() Ŭ������ �����.
		
//		ExamConsole console = new InlineExamConsole(exam); // DI
//		ExamConsole console = new GridExamConsole(); // 
//		���� �ȾѴ� ������ �޸� �ϰ� �Ҽ��ִ� ���Ͱ����ϸ�
//		console.setExam(exam);
		
//		Spring �� ���� ������ �Ʒ������� �и��ϰڴ�
//		���������� �����ϴ� ������� �ڵ带 ����
		
		ExamConsole console = ?;
		
		console.print();
		
	}

}
