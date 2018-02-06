package io.ayoue.common.tools;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtil {

	public static String formatXML(String str,String condeType) throws DocumentException, IOException{
		SAXReader reader = new SAXReader();
		// System.out.println(reader);
		// 注释：创建一个串的字符输入流
		StringReader in = new StringReader(str);
		Document doc = reader.read(in);
		// System.out.println(doc.getRootElement());
		// 注释：创建输出格式
		OutputFormat formater = OutputFormat.createPrettyPrint();
		//formater=OutputFormat.createCompactFormat();
		// 注释：设置xml的输出编码
		formater.setEncoding(condeType);
		// 生成缩进 
		formater.setIndent(true);
		// 不在文件头生成  XML 声明 (<?xml version="1.0" encoding="UTF-8"?>) 
		formater.setNewLineAfterDeclaration(false);
		
		// 设置回车变空格问题
		formater.setTrimText(false);
		formater.setPadText(true);
		// 设置输出的xml换行
		formater.setNewlines(true);
		
		// 注释：创建输出(目标)
		StringWriter out = new StringWriter();
		// 注释：创建输出流
		XMLWriter writer = new XMLWriter(out, formater);
		// 注释：输出格式化的串到目标中，执行后。格式化后的串保存在out中。
		writer.write(doc);
		writer.close();
		// System.out.println(out.toString());
		// 注释：返回我们格式化后的结果
		String result = out.toString();
		out.close();
		return result;
	}
}
