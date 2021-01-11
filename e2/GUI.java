package e2;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

	private static final long serialVersionUID = -6218820567019985015L;

	private Map<Pair<Integer, Integer>, JButton> cords = new HashMap<>();

	private int currentView = 0; // default
	private boolean avanti = true;

	public GUI(int size) {

		ActionListener al = (e) -> {
			final JButton bt = (JButton) e.getSource();
			if (bt.getText().equals("X")) {
				System.out.println("Hai premuto una X chiudo l'applicazione");
				System.exit(1);
			}
		};

		ActionListener al2 = (e) -> {
			changeVisual(cords, size);

		};

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		JPanel panel = new JPanel(new GridLayout(size, size));
		this.getContentPane().add(BorderLayout.CENTER, panel);
		JButton nextPage = new JButton(">");
		nextPage.addActionListener(al2);
		this.getContentPane().add(BorderLayout.SOUTH, nextPage);

		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				final JButton jb = new JButton();
				jb.addActionListener(al);
				cords.put(new Pair<Integer, Integer>(i, j), jb);
				panel.add(jb);
			}
		}
		changeVisual(cords, size);
		this.setVisible(true);
	}

	private void resetButton(Map<Pair<Integer, Integer>, JButton> cords) {
		Set<Pair<Integer, Integer>> allKey = cords.keySet();
		Iterator<Pair<Integer, Integer>> iter = allKey.iterator();
		while (iter.hasNext()) {
			cords.get(iter.next()).setText("");
			;
		}
	}

	private void changeVisual(Map<Pair<Integer, Integer>, JButton> cords, int size) {
		if(avanti) {
			currentView++;
		}
		else {
			currentView--;
		}
		if(currentView==(size/2+1)) {
			avanti=false;
		}
		if(currentView==1) {
			avanti=true;
		}
		int start = 0;
		int mid = size / 2;
		int end = size;
		resetButton(cords);
		cords.get(new Pair<Integer, Integer>(start + currentView - 1, start + currentView - 1)).setText("X");
		cords.get(new Pair<Integer, Integer>(start + currentView - 1, mid)).setText("X");
		cords.get(new Pair<Integer, Integer>(mid, start + currentView - 1)).setText("X");
		cords.get(new Pair<Integer, Integer>(start + currentView - 1, end - currentView)).setText("X");
		cords.get(new Pair<Integer, Integer>(end - currentView, start + currentView - 1)).setText("X");
		cords.get(new Pair<Integer, Integer>(end - currentView, end - currentView)).setText("X");
		cords.get(new Pair<Integer, Integer>(mid, end - currentView)).setText("X");
		cords.get(new Pair<Integer, Integer>(end - currentView, mid)).setText("X");

	}

}
