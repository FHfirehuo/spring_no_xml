package spring_4_no_xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {

		File file = new File("C:/Users/fire/Desktop/cpcplist.sh");
		File writerfile = new File("C:/Users/fire/Desktop/cpcplist.txt");

		InputStreamReader reader = null;
		OutputStreamWriter writer = null;

		try {

			reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			writer = new OutputStreamWriter(new FileOutputStream(writerfile), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String regex = "[0-9]*.jpg";
				String str = line;
				Pattern pat = Pattern.compile(regex);
				Matcher matcher = pat.matcher(str);
				while (matcher.find()) {
					String temp = str.substring(matcher.start(), matcher.end());
					String index = str;
					String index1 = str;
					String index2 = str;
					
					index = index.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_120.jpg");
					
					index1 = index1.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_200.jpg");

					index2 = index2.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_400.jpg");
					System.out.println(index);
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
				}

				String regex2 = "[0-9]*.gif";
				String str2 = line;
				Pattern pat2 = Pattern.compile(regex2);
				Matcher matcher2 = pat2.matcher(str2);
				while (matcher2.find()) {
					String temp2 = str2.substring(matcher2.start(), matcher2.end());

					String index = str2;
					String index1 = str2;
					String index2 = str2;
					
					
					index = index.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_120.gif");
					index1 = index1.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.gif");
					index2 = index2.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.gif");
					
				
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str2;
					String index4 = str2;
					String index5 = str2;
					String index6 = str2;
					index3 = index3.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + ".jpg");
					index4 = index4.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_120.jpg");
					index5 = index5.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.jpg");
					index6 = index6.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					
					break;
				}

				String regex3 = "[0-9]*.png";
				String str3 = line;
				Pattern pat3 = Pattern.compile(regex3);
				Matcher matcher3 = pat3.matcher(str3);
				while (matcher3.find()) {
					String temp3 = str3.substring(matcher3.start(), matcher3.end());
					String index = str3;
					String index1 = str3;
					String index2 = str3;
					index = index.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.png");
					index1 = index1.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.png");
					index2 = index2.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.png");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str3;
					String index4 = str3;
					String index5 = str3;
					String index6 = str3;
					index3 = index3.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + ".jpg");
					index4 = index4.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.jpg");
					index5 = index5.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.jpg");
					index6 = index6.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

				String regex4 = "[0-9]*.bmp";
				String str4 = line;
				Pattern pat4 = Pattern.compile(regex4);
				Matcher matcher4 = pat4.matcher(str4);
				while (matcher4.find()) {
					String temp4 = str4.substring(matcher4.start(), matcher4.end());
					String index = str4;
					String index1 = str4;
					String index2 = str4;
					index = index.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.bmp");
					index1 = index1.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.bmp");
					index2 = index2.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.bmp");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str4;
					String index4 = str4;
					String index5 = str4;
					String index6 = str4;
					index3 = index3.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + ".jpg");
					index4 = index4.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.jpg");
					index5 = index5.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.jpg");
					index6 = index6.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

			}

			File file2 = new File("C:/Users/fire/Desktop/cpexpand.sh");
			reader = new InputStreamReader(new FileInputStream(file2), "UTF-8");
			br = new BufferedReader(reader);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String regex = "[0-9]*.jpg";
				String str = line;
				Pattern pat = Pattern.compile(regex);
				Matcher matcher = pat.matcher(str);
				while (matcher.find()) {
					String temp = str.substring(matcher.start(), matcher.end());
					String index1 = str;
					String index2 = str;
					String index = str;
					index = index.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_120.jpg");
					index1 = index1.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_200.jpg");

					index2 = index2.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_400.jpg");

					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					break;
				}

				String regex2 = "[0-9]*.gif";
				String str2 = line;
				Pattern pat2 = Pattern.compile(regex2);
				Matcher matcher2 = pat2.matcher(str2);
				while (matcher2.find()) {
					String temp2 = str2.substring(matcher2.start(), matcher2.end());
					String index = str2;
					String index1 = str2;
					String index2 = str2;
					index = index.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_120.gif");
					index1 = index1.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.gif");
					index2 = index2.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.gif");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str2;
					String index4 = str2;
					String index5 = str2;
					String index6 = str2;
					index3 = index3.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + ".jpg");
					index4 = index4.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_120.jpg");
					index5 = index5.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.jpg");
					index6 = index6.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					
					break;
				}

				String regex3 = "[0-9]*.png";
				String str3 = line;
				Pattern pat3 = Pattern.compile(regex3);
				Matcher matcher3 = pat3.matcher(str3);
				while (matcher3.find()) {
					String temp3 = str3.substring(matcher3.start(), matcher3.end());
					String index = str3;
					String index1 = str3;
					String index2 = str3;
					index = index.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.png");
					index1 = index1.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.png");
					index2 = index2.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.png");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str3;
					String index4 = str3;
					String index5 = str3;
					String index6 = str3;
					index3 = index3.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + ".jpg");
					index4 = index4.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.jpg");
					index5 = index5.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.jpg");
					index6 = index6.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

				String regex4 = "[0-9]*.bmp";
				String str4 = line;
				Pattern pat4 = Pattern.compile(regex4);
				Matcher matcher4 = pat4.matcher(str4);
				while (matcher4.find()) {
					String temp4 = str4.substring(matcher4.start(), matcher4.end());
					String index = str4;
					String index1 = str4;
					String index2 = str4;
					index = index.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.bmp");
					index1 = index1.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.bmp");
					index2 = index2.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.bmp");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str4;
					String index4 = str4;
					String index5 = str4;
					String index6 = str4;
					index3 = index3.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + ".jpg");
					index4 = index4.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.jpg");
					index5 = index5.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.jpg");
					index6 = index6.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

			}

			File file3 = new File("C:/Users/fire/Desktop/cpfile.sh");
			reader = new InputStreamReader(new FileInputStream(file3), "UTF-8");
			br = new BufferedReader(reader);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String regex = "[0-9]*.jpg";
				String str = line;
				Pattern pat = Pattern.compile(regex);
				Matcher matcher = pat.matcher(str);
				while (matcher.find()) {
					String temp = str.substring(matcher.start(), matcher.end());
					String index = str;
					String index1 = str;
					String index2 = str;
					
					index = index.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_120.jpg");
					index1 = index1.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_200.jpg");

					index2 = index2.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_400.jpg");

					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					break;
				}

				String regex2 = "[0-9]*.gif";
				String str2 = line;
				Pattern pat2 = Pattern.compile(regex2);
				Matcher matcher2 = pat2.matcher(str2);
				while (matcher2.find()) {
					String temp2 = str2.substring(matcher2.start(), matcher2.end());
					String index = str2;
					String index1 = str2;
					String index2 = str2;
					index = index.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_120.gif");
					index1 = index1.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.gif");
					index2 = index2.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.gif");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str2;
					String index4 = str2;
					String index5 = str2;
					String index6 = str2;
					index3 = index3.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + ".jpg");
					index4 = index4.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.jpg");
					index5 = index5.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.jpg");
					index6 = index6.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

				String regex3 = "[0-9]*.png";
				String str3 = line;
				Pattern pat3 = Pattern.compile(regex3);
				Matcher matcher3 = pat3.matcher(str3);
				while (matcher3.find()) {
					String temp3 = str3.substring(matcher3.start(), matcher3.end());
					String index = str3;
					String index1 = str3;
					String index2 = str3;
					index = index.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.png");
					index1 = index1.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.png");
					index2 = index2.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.png");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str3;
					String index4 = str3;
					String index5 = str3;
					String index6 = str3;
					index3 = index3.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + ".jpg");
					index4 = index4.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.jpg");
					index5 = index5.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.jpg");
					index6 = index6.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					
					break;
				}

				String regex4 = "[0-9]*.bmp";
				String str4 = line;
				Pattern pat4 = Pattern.compile(regex4);
				Matcher matcher4 = pat4.matcher(str4);
				while (matcher4.find()) {
					String temp4 = str4.substring(matcher4.start(), matcher4.end());
					String index = str4;
					String index1 = str4;
					String index2 = str4;
					index = index.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.bmp");
					index1 = index1.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.bmp");
					index2 = index2.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.bmp");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					String index3 = str4;
					String index4 = str4;
					String index5 = str4;
					String index6 = str4;
					index3 = index3.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + ".jpg");
					index4 = index4.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.jpg");
					index5 = index5.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.jpg");
					index6 = index6.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.jpg");;
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}
				

			}

			File file4 = new File("C:/Users/fire/Desktop/cplist.sh");
			reader = new InputStreamReader(new FileInputStream(file4), "UTF-8");
			br = new BufferedReader(reader);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String regex = "[0-9]*.jpg";
				String str = line;
				Pattern pat = Pattern.compile(regex);
				Matcher matcher = pat.matcher(str);
				while (matcher.find()) {
					String temp = str.substring(matcher.start(), matcher.end());
					String index = str;
					String index1 = str;
					String index2 = str;
					
					index = index.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_120.jpg");
					index1 = index1.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_200.jpg");

					index2 = index2.replaceAll(temp, temp.substring(0, temp.lastIndexOf(".jpg")) + "_400.jpg");

					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					break;
				}

				String regex2 = "[0-9]*.gif";
				String str2 = line;
				Pattern pat2 = Pattern.compile(regex2);
				Matcher matcher2 = pat2.matcher(str2);
				while (matcher2.find()) {
					String temp2 = str2.substring(matcher2.start(), matcher2.end());
					String index = str2;
					String index1 = str2;
					String index2 = str2;
					index = index.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_120.gif");
					index1 = index1.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.gif");
					index2 = index2.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.gif");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					String index3 = str2;
					String index4 = str2;
					String index5 = str2;
					String index6 = str2;
					index3 = index3.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + ".jpg");
					index4 = index4.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_120.jpg");
					index5 = index5.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_200.jpg");
					index6 = index6.replaceAll(temp2, temp2.substring(0, temp2.lastIndexOf(".gif")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

				String regex3 = "[0-9]*.png";
				String str3 = line;
				Pattern pat3 = Pattern.compile(regex3);
				Matcher matcher3 = pat3.matcher(str3);
				while (matcher3.find()) {
					String temp3 = str3.substring(matcher3.start(), matcher3.end());
					String index = str3;
					String index1 = str3;
					String index2 = str3;
					index = index.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.png");
					index1 = index1.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.png");
					index2 = index2.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.png");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					String index3 = str3;
					String index4 = str3;
					String index5 = str3;
					String index6 = str3;
					index3 = index3.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + ".jpg");
					index4 = index4.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_120.jpg");
					index5 = index5.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_200.jpg");
					index6 = index6.replaceAll(temp3, temp3.substring(0, temp3.lastIndexOf(".png")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

				String regex4 = "[0-9]*.bmp";
				String str4 = line;
				Pattern pat4 = Pattern.compile(regex4);
				Matcher matcher4 = pat4.matcher(str4);
				while (matcher4.find()) {
					String temp4 = str4.substring(matcher4.start(), matcher4.end());
					String index = str4;
					String index1 = str4;
					String index2 = str4;
					index = index.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.bmp");
					index1 = index1.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.bmp");
					index2 = index2.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.bmp");
					System.out.println(index1);
					System.out.println(index2);
					writer.write(index + "\r\n");
					writer.write(index1 + "\r\n");
					writer.write(index2 + "\r\n");
					
					String index3 = str4;
					String index4 = str4;
					String index5 = str4;
					String index6 = str4;
					index3 = index3.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + ".jpg");
					index4 = index4.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_120.jpg");
					index5 = index5.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_200.jpg");
					index6 = index6.replaceAll(temp4, temp4.substring(0, temp4.lastIndexOf(".bmp")) + "_400.jpg");
					writer.write(index3 + "\r\n");
					writer.write(index4 + "\r\n");
					writer.write(index5 + "\r\n");
					writer.write(index6 + "\r\n");
					break;
				}

			}

			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}

}
