package com.bkhn.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.bkhn.model.Subject;

public class FileIO {
	public static final String DEFAULT_PATH = "D:\\OOP\\data";

	public boolean WriteStringToFile(String content, String filePath, String fileName) {
		try {
			File directory = new File(DEFAULT_PATH);
			if (!directory.exists())
				directory.mkdirs();
			File file = new File(filePath + "\\" + fileName);
			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/*------------------------ Handle subjects ---------------------*/
	public int UpdateListSubject(ArrayList<Subject> subjects) {
		String content = "";
		for (int i = 0; i < subjects.size(); i++) {
			content += subjects.get(i).ToJsonString();
			content += "\n";
		}
		WriteStringToFile(content, DEFAULT_PATH, "subjects.txt");
		return subjects.size();
	}

	public ArrayList<Subject> GetListSubject() {
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		try {
			File directory = new File(DEFAULT_PATH);
			if (!directory.exists())
				directory.mkdirs();
			BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_PATH + "\\" + "subjects.txt"));
			String str;

			while ((str = reader.readLine()) != null) {
				if (!str.equals("") && !str.equals("\n")) {
					Object obj = JSONValue.parse(str);
					JSONObject object = (JSONObject) obj;
					String name = (String)object.get("name");
					String id = (String)object.get("id");
					int numChapter = Integer.parseInt(((Long)object.get("numChapter")).toString());
					String intro = (String)object.get("introduction");
					Subject subject = new Subject(name, id, numChapter, intro);
					subjects.add(subject);
				}
			}
		} catch (IOException e) {
		}
		return subjects;
	}
}
