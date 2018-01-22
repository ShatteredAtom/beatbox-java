import java.awt.*;
import javax.swing*;
import java.io.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

public class BeatBoxFinal {

	JFrame theFrame;
	JPanel mainPanel;
	JList incomingList;
	JTextField userMessage;
	ArrayList<JCheckBox> checkboxList;
	int nextNum;
	Vector<String> listVector = new Vector<String, boolean[]>();
	String userName;
	ObjectOutputStream out;
	ObjectInputStream in;
	HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();
	
	Sequencer sequencer;
	Sequence sequence;
	Sequence mySequence = null;
	Track track;
	
	
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
	
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
public static void main (String[] args) {
	new BeatBoxFinal().startUp(args[0]);
}
public void startUp(String name) {
	userName = name;
	
	try {
	  Socket sock = new Socket("127.0.0.1", 4242);
		out = new ObjectOutputStream(sock.getOutputStream());
		in = new ObjectInputStream(sock.getInputStream());
		Thread remote = new Thread(new RemoteReader());
		remote.start();
	}  catch(Exception ex) {
			System.out.println("couldn't connect - you'll have to play alone.");
	}
	setUpMidi();
	buildGUI();
}
	
public void buildGUI() {
	theFrame = new JFrame("Cyber BeatBox");
	BorderLayout layout = new BorderLayout();
	JPanel background = new JPanel(layout);
	background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	
	checkboxList = new ArrayList<JCheckBox>();
	
	Box buttonBox = new Box(BoxLayout.Y_AXIS);
	JButton start = new JButton("Start");
	start.addActionListener(new MyStartListener());
	buttonBox.add(start);
	
	JButton stop = new JButton("Stop");
	stop.addActionListener(new MyStopListener());
	buttonBox.add(stop);
	
	JButton upTempo = new JButton("Tempo Up");
	upTempo.addActionListener(new MyUpTempoListener());
	buttonBox.add(upTempo);
	
	JButton downTempo = new JButton("Tempo Down");
	downTempo.addActionListener(new MyDownTempoListener());
	buttonBox.add(downTempo);
	
	
