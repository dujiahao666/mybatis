package com.powernode.xml.test;

import org.apache.ibatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/4 20:14
 * @description:
 */
public class PaerxmTest {
    @Test
    public void testPxml() throws IOException, DocumentException {
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read(Resources.getResourceAsStream("persons.xml"));
        List<Element> elements = document.selectNodes("/persons/person/name");
        for (Element element : elements) {
            System.out.println(element.getName());
            System.out.println(element.getText());
        }

    }
}
