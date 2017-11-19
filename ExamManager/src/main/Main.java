package main;

import java.io.File;

import com.bkhn.controller.Controller;
import com.bkhn.model.Exam;
import com.bkhn.util.FileIO;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		Exam exam = new Exam();
		FileIO fileIO = new FileIO();
		fileIO.UpdateExam(exam);
	}
}
