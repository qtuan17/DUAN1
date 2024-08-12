/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author This PC
 */
public class XImage {
    public static Image getAppIcon(){
        URL url = XImage.class.getResource("/icons/fpt.png");// dấu chấm thì thay bằng dấu / vd: study.icon thành /study/icon/
        return new ImageIcon(url).getImage();
}
}