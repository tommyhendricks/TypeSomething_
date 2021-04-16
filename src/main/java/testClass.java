import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

public class testClass extends JFrame {
    private int findLastNonWordChar (String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int findFirstNonWordChar (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }

    public testClass () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
        final AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(private|public|protected)"))
                            setCharacterAttributes(wordL, wordR - wordL, attr, false);
                        else
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                        wordL = wordR;
                    }
                    wordR++;
                }
            }

            public void remove (int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches("(\\W)*(private|public|protected)")) {
                    setCharacterAttributes(before, after - before, attr, false);
                } else {
                    setCharacterAttributes(before, after - before, attrBlack, false);
                }
            }
        };
        
        JTextPane txt = new JTextPane(doc);
        txt.setText("public class Hi {}");
        add(new JScrollPane(txt));
        setVisible(true);
    }

    public static void main (String args[]) {
      try{
      JFrame frame = new JFrame("Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container container = frame.getContentPane();
      JTextPane textPane = new JTextPane();
      textPane.setBackground(Color.blue);
      textPane.setBackground(Color.green);
      
      SimpleAttributeSet attributeSet = new SimpleAttributeSet();
      StyleConstants.setItalic(attributeSet, true);
      textPane.setCharacterAttributes(attributeSet, true);
      
      textPane.setText("World Cup Cricket begins from ");
      Font font = new Font("Serif", Font.ITALIC, 18);
      textPane.setFont(font);
      
      StyledDocument doc = textPane.getStyledDocument();
      Style style = textPane.addStyle("", null);
      StyleConstants.setForeground(style, Color.red);
      StyleConstants.setBackground(style, Color.white);
      doc.insertString(doc.getLength(), "30th May ", style);
      StyleConstants.setForeground(style, Color.yellow);
      StyleConstants.setBackground(style, Color.gray);
      doc.insertString(doc.getLength(), "2019", style);
      JScrollPane scrollPane = new JScrollPane(textPane);
      container.add(scrollPane, BorderLayout.CENTER);
      frame.setSize(550, 300);
      frame.setVisible(true);
      }
      catch(Exception e){
      }
    }
}