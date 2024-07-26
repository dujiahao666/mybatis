package com.powernode.xml.test;



import org.apache.ibatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/4 19:12
 * @description:
 */
public class ParseXMLByDom4j {

    @Test
    public void testParseMyBatisCongigXml() throws IOException, DocumentException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(Resources.getResourceAsStream("mybatis-config.xml"));
        List list = document.selectNodes("/configuration//property");
        System.out.println(list.size());
        for (Object object : list) {
          Element element = (Element) object;
            System.out.println(element.getName());
        }

        System.out.println("=======");
        List<Node> nodes = document.selectNodes("//environment[@id]");
        for (Node node : nodes) {
            Element element=(Element) node;
            System.out.println(element.getName());
        }
    }

}
