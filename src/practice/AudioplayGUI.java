package practice;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AudioplayGUI extends JFrame {
    Titleframe tf = new Titleframe();
    PlayList pl = new PlayList();
    PlayButtons pb = new PlayButtons();

    public AudioplayGUI() {
        setTitle("Audio play List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(tf, BorderLayout.NORTH);
        c.add(pl, BorderLayout.CENTER);
        c.add(pb, BorderLayout.SOUTH);

        setVisible(true);
    }
    class Titleframe extends JPanel {
        private JLabel title;
        public Titleframe() {
            title = new JLabel("체크된 곡만 한번 순서대로 연주합니다.");
            title.setBackground(Color.lightGray);
            add(title);
        }
    }
    class PlayList extends JPanel {
        private JCheckBox[] checks = new JCheckBox[5];
        public PlayList() {
            for (int i = 0 ; i < checks.length ; i++) {
                checks[i] = new JCheckBox("");
                add(checks[i]);
            }
        }
    }
    class PlayButtons extends JPanel implements ActionListener {
        private JButton play, stop;
        private Clip clip;
        public PlayButtons() {
            play = new JButton("연주 시작");
            stop = new JButton("연주 종료");

            add(play);
            add(stop);
            loadAudio("");
        }
        private void loadAudio(String pathName) {
            try {
                clip = AudioSystem.getClip();
                File audioFile = new File(pathName);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip.open();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void actionPerformed (ActionEvent e) {
            Object source = e.getSource();
            if (source.equals(play)) {
                clip.start();
            } else if (source.equals(stop)) {
                clip.stop();
            }
        }
    }
}
