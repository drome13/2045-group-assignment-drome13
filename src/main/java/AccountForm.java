import com.bank.Account;
import com.bank.Banker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AccountForm {
    private JPanel pnlMain;
    private JPanel pnlCenterMain;
    private JPanel pnlInnerNorth;
    private JPanel pnlInnerCenter;
    private JButton btnSave;
    private JButton btnCompute;
    private JTextField txtName;
    private JList lstAccounts;
    private JComboBox cmbAccountType;
    private JLabel actType;
    private JTextField txtBalance;
    private JLabel lblBalance;
    private JLabel lblRate;
    private JTextField txtRate;
    private JTextField txtPeriod;
    private JLabel lblPeriod;
    private JLabel lblTerm;
    private JTextField txtTerm;
    private JLabel lblName;

    private Vector<Account> allAccounts = new Vector<>();

    public AccountForm() {

        initializeAccountTypeComboBox();
        lstAccounts.setListData(allAccounts);


        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String strName = txtName.getText();

                String strBalance = txtBalance.getText();
                double balance = Double.parseDouble(strBalance);

                String strRate = txtRate.getText();
                int rate = Integer.parseInt(strRate);

                String strPeriod = txtPeriod.getText();
                int period = Integer.parseInt(strPeriod);

                String type = cmbAccountType.getSelectedItem().toString();
                Account account = Banker.createAccount(type);

                Account.setBalance(balance);
                Account.setRate(rate);
                Account.setPeriod(period);


                allAccounts.add(account);
                lstAccounts.updateUI();



            }
        });
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allAccounts.stream().forEach(account -> {account.compute();});
                lstAccounts.updateUI();

            }
        });
        cmbAccountType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( cmbAccountType.getSelectedItem().toString().equals(Banker.CERTIFICATEOF_DEPOSIT)){
                    txtTerm.setEnabled(true);
                }
                else {
                    txtTerm.setEnabled(false);
                }
            }
        });
    }

    private void initializeAccountTypeComboBox() {
        DefaultComboBoxModel<String> accountTypesModel = new DefaultComboBoxModel<>();
        accountTypesModel.addElement(Banker.CHECKING);
        accountTypesModel.addElement(Banker.SAVINGS);
        accountTypesModel.addElement(Banker.CERTIFICATEOF_DEPOSIT);
        cmbAccountType.setModel(accountTypesModel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AccountForm");
        frame.setContentPane(new AccountForm().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents(){

    }
}
