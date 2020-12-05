package notepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JavaMemoFontEvt extends WindowAdapter implements ActionListener,ListSelectionListener {

	//Has - A ���踦 ���� instance ����
	private JavaMemoFont jmf;
	private JavaMemo jm;
	
	
	//JList���� ���õ� ������ preview������ �ٲٱ� ���� preview ���ĺ��� ����
	private String font;
	private int style;
	private int size;
	
	//Has-A ���� �α�
	public JavaMemoFontEvt(JavaMemo jm, JavaMemoFont jmf) {
		this.jmf = jmf;
		this.jm = jm;
	}//JavaMemoFontEvt
	
	
	//ListSelectionEvent�� �ι� ����Ǳ� ������ 1���������� �����ϱ� ���� ���� ����
	private boolean flag;
	@Override
	public void valueChanged(ListSelectionEvent le) {

		//preview �⺻ ���� �����ͼ� �� �Ҵ�
		font = jmf.getPreviewFont();
		style = jmf.getPreviewStyle();
		size = jmf.getPreviewSize();
		
		//JList�� ���������� preview�� ���� �ǽð� ����Ǳ� ���� �̺�Ʈ��
		
		if(le.getSource() == jmf.getJlFont()) {
			font = JavaMemo.FONT[jmf.getJlFont().getSelectedIndex()];
			jmf.getJtfFont().setText(jmf.getDlmFont().get(jmf.getJlFont().getSelectedIndex()));
			jmf.getJiblPreview().setFont(new Font(font,style,size));
		}//end if

		if(le.getSource() == jmf.getJlStyle()) {
			style = JavaMemo.STYLE[jmf.getJlStyle().getSelectedIndex()];
			jmf.getJtfStyle().setText(jmf.getDlmStyle().get(jmf.getJlStyle().getSelectedIndex()));
			jmf.getJiblPreview().setFont(new Font(font,style,size));
		}//end if
		
		if(le.getSource() == jmf.getJlSize()) {
			size = JavaMemo.SIZE[(int)(jmf.getJlSize().getSelectedIndex())];
			jmf.getJtfSize().setText(String.valueOf(jmf.getDlmSize().get(jmf.getJlSize().getSelectedIndex())));
			jmf.getJiblPreview().setFont(new Font(font,style,size));
		}//end if
			flag = !flag;
	}//valueChanged

	
	@Override
	public void actionPerformed(ActionEvent ae) {

		//ComboBox�� ���� ����� ������ preview text���� �̺�Ʈ
		if(ae.getSource() == jmf.getJcbScript()) {
			String flag = jmf.getDjcbScript().getElementAt(jmf.getJcbScript().getSelectedIndex());
			if("�ѱ�".equals(flag)) {
				jmf.getJiblPreview().setText("AaBbCc������");
			}//end if
			if("����".equals(flag)) {
				jmf.getJiblPreview().setText("AaBbCc");
			}//end if
		}//end if
		
		//Font Dialog �ݱ� �̺�Ʈ
		if(ae.getSource() == jmf.getJbtnClose()) {
			jmf.dispose();
		}//end if
		
		//Font Dialog ���� �̺�Ʈ
		if(ae.getSource() == jmf.getJbtnApply()) {
			jm.getJtaMemo().setFont(new Font(font, style, size));
			jmf.dispose();
		}//end if
		
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		jmf.dispose();
	}//windowClosing

	
}//JavaMemoFontEvt
