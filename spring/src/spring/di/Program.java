package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
//		Exam exam = new NewlecExam();
		// top -> down 방식
		// Interface Exam 을 만들고 이것을 상속받을 NewlecExam() 클래스를 만든다.
		
//		ExamConsole console = new InlineExamConsole(exam); // DI
//		ExamConsole console = new GridExamConsole(); // 
//		뺏다 꽂앗다 겳합을 달리 하게 할수있다 위와같이하면
//		console.setExam(exam);
		
//		Spring 은 위의 과정과 아래과정을 분리하겠다
//		스프링에게 지시하는 방법으로 코드를 변경
		
		ExamConsole console = ?;
		
		console.print();
		
	}

}
