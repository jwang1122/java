package com.huaxia.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class ImageHandler {
	Toolkit t = Toolkit.getDefaultToolkit(); // get instance of Toolkit

    public static void main(String[] args) {
    	ImageHandler handler = new ImageHandler();
        handler.createAndShowJFrame();
    }

    public void createAndShowJFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = createJFrame();
                frame.setVisible(true);

            }
        });
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        //frame.setResizable(false);//make it un-resizeable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test");

        ArrayList<BufferedImage> images = null;

        try {
            images = getImagesArrayList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        final ImageViewPanel imageViewPanel = new ImageViewPanel(images);
        JScrollPane jsp = new JScrollPane(imageViewPanel);
        jsp.setPreferredSize(new Dimension(400, 400));
        frame.add(jsp);

        JPanel controlPanel = new JPanel();
        JButton addLabelButton = new JButton("Delete Selected Image");
        addLabelButton.addActionListener(new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                imageViewPanel.removeFocusedImageLabel();
            }
        });
        controlPanel.add(addLabelButton);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();

        return frame;
    }

    private ArrayList<BufferedImage> getImagesArrayList() throws Exception {
        ArrayList<BufferedImage> images = new ArrayList<>();
		URL iconUrl = getClass().getResource("clubA.png");
        images.add(resize(ImageIO.read(iconUrl), 100, 100));
        iconUrl = getClass().getResource("clubA.png");
        images.add(resize(ImageIO.read(iconUrl), 100, 100));
        return images;
    }

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
}

class ImageViewPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel NO_IMAGES = new JLabel("No Images");
    ArrayList<BufferedImage> images;
    ArrayList<MyLabel> imageLabels;

    public ImageViewPanel(ArrayList<BufferedImage> images) {

        this.images = images;
        imageLabels = new ArrayList<>();

        for (BufferedImage bi : images) {
            imageLabels.add(new MyLabel(new ImageIcon(bi), this));
        }
        layoutLabels();

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, true), "Delete pressed");
        getActionMap().put("Delete pressed", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                removeFocusedImageLabel();
            }
        });
    }

    void removeFocusedImageLabel() {
        if (focusedLabel == null) {
            return;
        }
        imageLabels.remove(focusedLabel);
        remove(focusedLabel);
        layoutLabels();
    }

    private void layoutLabels() {
        if (imageLabels.isEmpty()) {
            add(NO_IMAGES);
        } else {
            remove(NO_IMAGES);
            for (JLabel il : imageLabels) {
                add(il);
            }
        }
        revalidate();
        repaint();
    }
    private MyLabel focusedLabel;

    void setFocusedLabel(MyLabel labelToFocus) {
        if (focusedLabel != null) {
            focusedLabel.setBorder(null);
            focusedLabel.setClicked(false);
        }
        focusedLabel = labelToFocus;

        focusedLabel.setBorder(new LineBorder(Color.GREEN));
    }
}

class MyLabel extends JLabel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ImageViewPanel imageViewPanel;
    private boolean clicked = false;

    public MyLabel(Icon image, ImageViewPanel imageViewPanel) {
        super(image);
        this.imageViewPanel = imageViewPanel;
        initLabel();
    }

    public MyLabel(String text, ImageViewPanel imageViewPanel) {
        super(text);
        this.imageViewPanel = imageViewPanel;
        initLabel();
    }

    private void initLabel() {
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clicked = true;
                imageViewPanel.setFocusedLabel(MyLabel.this);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                super.mouseEntered(me);
                if (clicked) {
                    return;
                }
                setBorder(new LineBorder(Color.ORANGE));
                //call for focus mouse is over this component
                requestFocusInWindow();
            }
        });

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                if (clicked) {
                    return;
                }

                setBorder(null);
            }
        });
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isClicked() {
        return clicked;
    }
}