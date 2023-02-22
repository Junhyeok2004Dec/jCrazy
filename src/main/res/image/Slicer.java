package main.res.image;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Slicer extends JFrame {

	private static int x,y;

	static int size = 256;


	static int[][] getImage = new int[size][size];
	static int[][] resultImage = new int[size][size];


	static Container content;




	public static void main(String[] args) throws IOException

	{

		System.out.println("툴입니다. 프로그램 외부에서 작동합니다.");

		new Slicer();


	}


	Slicer() { // Constructor

		// title
		setTitle("사진 처리 프로그램");
		// 종료 버튼을 누르면 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content = getContentPane();

		// 메뉴 추가
		menu();

		// 패널 추가
		DrawImage panel = new DrawImage();
		content.add(panel, BorderLayout.CENTER);

		// 윈도 창의 메뉴나 틀의 폭까지 고려해서 크기 조절
		setSize(8 + size + 8, 25 + 31 + size + 8);

		// 윈도 창 보기
		setVisible(true);

		// 윈도 창 새로 고침
		displayImage();
	}



	void menu() {


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("파일");
		JMenuItem loadComponent = new JMenuItem("불러오기");
		JMenuItem saveComponent = new JMenuItem("저장하기");
		JMenuItem exit = new JMenuItem("종료");

		menu.add(loadComponent);
		menu.add(saveComponent);
		menu.add(exit);

		menuBar.add(menu);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}});

		loadComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				load();
			}
		});
		saveComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});


	}


	void load(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("파일 불러오기");
		fileChooser.setFileFilter(new FileNameExtensionFilter("png File", "png")); // 파일필터
		fileChooser.setMultiSelectionEnabled(false);// 다중 선택 불가
		int returnVal = fileChooser.showOpenDialog(this); // show openDialog
		if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
			try{
				loadImage(fileChooser.getSelectedFile().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void save() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("파일 저장");
		fileChooser.setFileFilter(new FileNameExtensionFilter("png File", "png")); // 파일필터
		fileChooser.setMultiSelectionEnabled(false); // 다중 선택 불가
		int returnVal = fileChooser.showSaveDialog(this); // show saveDialog
		if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
			try {
				saveImage(fileChooser.getSelectedFile().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static void loadImage(String path) throws Exception {
		// 이미지
		File inFile;
		inFile = new File(path);

		// 파일 스트림
		FileInputStream inFileStream;
		inFileStream = new FileInputStream(inFile.getPath());

		// 읽어온 이미지 배열에 저장
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				getImage[i][k] = inFileStream.read();
				resultImage[i][k] = getImage[i][k];
			}
		}

		// close
		inFileStream.close();

		displayImage();
	}

	class DrawImage extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int R, G, B;

			// 픽셀 하나하나를 화면에 출력
			for (int i = 0; i < size; i++) {
				for (int k = 0; k < size; k++) {
					R = G = B = (int) resultImage[i][k];

					g.setColor(new Color(R, G, B));
					g.drawRect(k, i, 1, 1);
				}
			}
		}
	}


	static void saveImage(String path) throws Exception {
		// 이미지
		File outFile;
		outFile = new File(path);

		// 파일 스트림
		FileOutputStream outFileStream;
		outFileStream = new FileOutputStream(outFile.getPath()+".png");

		// 이미지 파일로 저장
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				outFileStream.write(resultImage[i][k]);
			}
		}

		// close
		outFileStream.close();

		// messageDialog
		JOptionPane.showMessageDialog(null, "파일 저장 성공", "파일 저장", JOptionPane.INFORMATION_MESSAGE);
	}

	static void displayImage() {
		// outImage의 내용이 변경될 때마다 이 메소드를 호출하여 화면에 변경된 내용을 출력함
		Graphics g = content.getGraphics();
		content.paintAll(g);
	}


}
