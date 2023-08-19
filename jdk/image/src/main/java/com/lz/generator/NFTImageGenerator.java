package com.lz.generator;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Coordinate;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class NFTImageGenerator {

    private BufferedImage cropToCircle(BufferedImage sourceImage) {
        BufferedImage circleBuffer = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = circleBuffer.createGraphics();

        // 创建一个圆形的剪裁区域
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, sourceImage.getWidth(), sourceImage.getHeight());
        Area clearArea = new Area(new Rectangle(0, 0, sourceImage.getWidth(), sourceImage.getHeight()));
        clearArea.subtract(new Area(circle));
        
        g2.setClip(circle);
        g2.drawImage(sourceImage, 0, 0, null);
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(clearArea);
        g2.dispose();
        
        return circleBuffer;
    }

    /**
     *
     * @param bgUrl 背景图: https://image.dfans.xyz/a/1692759592662077440.webp
     * @param avatarUrl 头像水印图: https://image.dfans.xyz/a/1656110840564289536.webp
     *                  创作者标志图 √: https://image.dfans.xyz/a/1692760657285484544.webp
     * @return
     * @throws IOException
     */
    public BufferedImage generateNFTImage(String bgUrl, String avatarUrl) throws IOException {
        //获取背景图资源
        BufferedImage bgImage = Thumbnails.of(new URL(bgUrl)).size(300, 304).asBufferedImage();
        //获取水印头像图资源 大小: 120 x 120
        BufferedImage avatarImage = Thumbnails.of(new URL(avatarUrl)).size(120, 120).asBufferedImage();
        // 将头像裁剪成圆形
        avatarImage = cropToCircle(avatarImage);

        //确定水印图的位置信息
        BufferedImage resultImage = Thumbnails.of(bgImage)
                .size(bgImage.getWidth(), bgImage.getHeight())
                .watermark(new Coordinate(90,52), avatarImage, 1.0f)
                .asBufferedImage();
        //处理文字信息
        Graphics2D graphics = resultImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        //字体
        Font font = new Font("Poppins SemiBold", Font.BOLD, 16);
        graphics.setColor(Color.BLACK);
        graphics.setFont(font);
        //文字
        String text = "Investment Contract";
        FontMetrics fm = graphics.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int x = (bgImage.getWidth() - textWidth) / 2;
        graphics.drawString(text,x,40);


        Font font2 = new Font("Ephesis", Font.ITALIC, 20);
        graphics.setColor(Color.BLACK);
        graphics.setFont(font2);
        //文字
        String text2 = "Davikah Hoorne";
        FontMetrics fm2 = graphics.getFontMetrics();
        int textWidth2 = fm2.stringWidth(text2);
        int x2 = (bgImage.getWidth() - textWidth2) / 2;
        graphics.drawString(text2,x2,236);

        graphics.dispose();
        return resultImage;
    }

    public static void main(String[] args) {
        // 示例使用
        NFTImageGenerator generator = new NFTImageGenerator();
        try {
            BufferedImage result = generator.generateNFTImage(
                    "https://image.dfans.xyz/a/1692759592662077440.webp",
                    "https://image.dfans.xyz/a/1656110840564289536.webp"
            );
            // 输出到文件或其他位置
            Thumbnails.of(result).size(result.getWidth(), result.getHeight()).toFile("C:\\Users\\admin\\Desktop\\output.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
