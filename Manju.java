package typecasting;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// ---------------- BOOKING CLASS ----------------
class Booking1 {
    String name, from, to;
    ArrayList<String> seats;

    Booking1(String name, String from, String to, ArrayList<String> seats) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.seats = seats;
    }
}

// ---------------- LOGIN PAGE ----------------
@SuppressWarnings("serial")
class LoginPage1 extends JFrame implements ActionListener {

    JTextField userField;
    JPasswordField passField;

    LoginPage1() {
        setTitle("Login");
        setSize(500, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/typecasting/bus.jpg.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(2000, 1000, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(bgImg));

        setContentPane(bgLabel);
        bgLabel.setLayout(null);
        
        
        
        //getContentPane().setBackground(Color.cyan);
        int centerX=getWidth()/2;

        JLabel title = new JLabel("Bus Ticket Login");
        title.setBounds(centerX-80, 40, 300, 30);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial",Font.BOLD,26));
        bgLabel.add(title);

        JLabel user = new JLabel("Username:");
        user.setBounds(centerX-120, 90, 100, 25);
        user.setForeground(Color.black);
        bgLabel.add(user);

        userField = new JTextField();
        userField.setBounds(centerX-20, 90, 120, 25);
        bgLabel.add(userField);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(centerX-120, 130, 100, 25);
        pass.setForeground(Color.black);
        bgLabel.add(pass);

        passField = new JPasswordField();
        passField.setBounds(centerX-20, 130, 120, 25);
        bgLabel.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(centerX-50, 180, 100, 30);
        loginBtn.setBackground(Color.blue);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener(this);
        bgLabel.add(loginBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (userField.getText().equals("manju") &&
                new String(passField.getPassword()).equals("1234")) {

            new Dashboard1(userField.getText());
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login!");
        }
    }
}

// ---------------- DASHBOARD ----------------
@SuppressWarnings("serial")
class Dashboard1 extends JFrame implements ActionListener {

    ArrayList<Booking1> bookings = new ArrayList<>();

    JButton bookBtn, viewBtn, cancelBtn,logoutBtn,viewBusBtn;

    Dashboard1(String user) {
        setTitle("Dashboard");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/typecasting/bus1.jpeg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(2000, 1000, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(bgImg));

        setContentPane(bgLabel);
        bgLabel.setLayout(null);
        //getContentPane().setBackground(Color.yellow);

        JLabel welcome = new JLabel("Welcome " + user);
        welcome.setBounds(120, 20, 200, 30);
        welcome.setForeground(Color.CYAN);
        welcome.setFont(new Font("Arial",Font.BOLD,26));
        add(welcome);
        
        viewBusBtn = new JButton("View Buses");
        viewBusBtn.setBounds(120, 70, 150, 30);
        viewBusBtn.addActionListener(this);
        add(viewBusBtn);

        bookBtn = new JButton("Book Ticket");
        bookBtn.setBounds(120, 110, 150, 30);
        bookBtn.addActionListener(this);
        add(bookBtn);

        viewBtn = new JButton("View Bookings");
        viewBtn.setBounds(120, 150, 150, 30);
        viewBtn.addActionListener(this);
        add(viewBtn);

        cancelBtn = new JButton("Cancel Booking");
        cancelBtn.setBounds(120, 190, 150, 30);
        cancelBtn.addActionListener(this);
        add(cancelBtn);
        
        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(120, 230, 150, 30);
        logoutBtn.setBackground(Color.red);
        logoutBtn.setForeground(Color.black);
        logoutBtn.addActionListener(this);
        add(logoutBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    	
    	 if (e.getSource() == viewBusBtn)
             new ViewBusFrame1();

        if (e.getSource() == bookBtn)
            new BookTicketFrame1(bookings);

        if (e.getSource() == viewBtn)
            new ViewBookingsFrame1(bookings);

        if (e.getSource() == cancelBtn)
            new CancelBookingFrame1(bookings);
        
        
        if (e.getSource() == logoutBtn) {
            new LoginPage1();
            dispose();
           
    }
}
}

// ---------------- BOOK FORM ----------------

class BookTicketFrame1 extends JFrame implements ActionListener {

    JTextField nameField, fromField, toField;
    ArrayList<Booking1> bookings;

    BookTicketFrame1(ArrayList<Booking1> bookings) {
        this.bookings = bookings;

        setTitle("Book Ticket");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/typecasting/bus3.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(bgImg));

        setContentPane(bgLabel);
        bgLabel.setLayout(null);
       // getContentPane().setBackground(Color.blue);

        add(new JLabel("Name:")).setBounds(30, 30, 80, 25);
        nameField = new JTextField();
        nameField.setBounds(100, 30, 120, 25);
        add(nameField);

        add(new JLabel("From:")).setBounds(30, 70, 80, 25);
        fromField = new JTextField();
        fromField.setBounds(100, 70, 120, 25);
        add(fromField);

        add(new JLabel("To:")).setBounds(30, 110, 80, 25);
        toField = new JTextField();
        toField.setBounds(100, 110, 120, 25);
        add(toField);

        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(100, 150, 100, 30);
        nextBtn.addActionListener(this);
        add(nextBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        new SeatSelectionFrame1(
                nameField.getText(),
                fromField.getText(),
                toField.getText(),
                bookings
        );
        dispose();
    }
}


//---------------- VIEW BUSES ----------------
class ViewBusFrame1 extends JFrame {

 ViewBusFrame1() {
     setTitle("Available Buses");
     setSize(400, 200);

     String data[][] = {
             {"1", "Bangalore", "Mysore", "09:00 - 09:30"},
             {"2", "Bangalore", "Chennai", "10:00 - 10:25"},
             {"3", "Bangalore", "Hyderabad", "09:45 - 10:00"},
             {"4", "Anantapur", "Bangalore", "11:00 - 11:15"},
             {"5", "Uravakonda", "Anantapur", "11:30 - 11:45"},
             {"6", "Chennai", "Honnur", "12:00 - 12:10"},
             {"6", "kanekal", "Rayadurgam", "12:30 - 12:45"},
             {"7", "udipi", "Aadoni", "12:45 - 1:00"},
             {"8", "Delhi", "Guntur", "01:00 - 01:25"},
             {"9", "Gujarath", "Bihar", "01:30 - 01:45"},
             {"10", "Goa", "Gooty", "02:00 - 03:00"},
             
     };

     String col[] = {"ID", "From", "To","Timings"};
     

     JTable table = new JTable(data, col);
     add(new JScrollPane(table));

     setVisible(true);
 }
}

// ---------------- SEAT SELECTION ----------------
class SeatSelectionFrame1 extends JFrame implements ActionListener {

    JButton seats[][] = new JButton[4][5];
    boolean selected[][] = new boolean[4][5];

    ArrayList<Booking1> bookings;
    String name, from, to;

    String rows[] = {"A", "B", "C", "D"};

    SeatSelectionFrame1(String name, String from, String to,
                        ArrayList<Booking1> bookings) {

        this.name = name;
        this.from = from;
        this.to = to;
        this.bookings = bookings;

        setTitle("Select Seats");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 5, 10, 10));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {

                String seat = rows[i] + (j + 1);

                seats[i][j] = new JButton(seat);

                if (isBooked(seat)) {
                    seats[i][j].setEnabled(false);
                    seats[i][j].setBackground(Color.GRAY);
                } else {
                    seats[i][j].setBackground(Color.GREEN);
                }

                seats[i][j].addActionListener(this);
                panel.add(seats[i][j]);
            }
        }

        JButton confirm = new JButton("Proceed to Payment");
        confirm.addActionListener(e -> confirm());

        add(panel, BorderLayout.CENTER);
        add(confirm, BorderLayout.SOUTH);

        setVisible(true);
    }

    boolean isBooked(String s) {
        for (Booking1 b : bookings)
            if (b.seats != null && b.seats.contains(s)) return true;
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++)
                if (e.getSource() == seats[i][j]) {

                    selected[i][j] = !selected[i][j];

                    seats[i][j].setBackground(
                            selected[i][j] ? Color.RED : Color.GREEN
                    );
                }
    }

    void confirm() {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 5; j++)
                if (selected[i][j])
                    list.add(rows[i] + (j + 1));

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select seats!");
            return;
        }

        new PaymentFrame1(name, from, to, list, bookings);
        dispose();
    }
}

// ---------------- PAYMENT ----------------
class PaymentFrame1 extends JFrame implements ActionListener {

    JTextField card, upi;
    JRadioButton cardOpt, upiOpt;

    ArrayList<Booking1> bookings;
    String name, from, to;
    ArrayList<String> seats;

    PaymentFrame1(String name, String from, String to,
                  ArrayList<String> seats,
                  ArrayList<Booking1> bookings) {

        this.name = name;
        this.from = from;
        this.to = to;
        this.seats = seats;
        this.bookings = bookings;

        setTitle("Payment");
        setSize(400, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.magenta);

        cardOpt = new JRadioButton("Card");
        cardOpt.setBounds(50, 30, 100, 25);

        upiOpt = new JRadioButton("UPI");
        upiOpt.setBounds(200, 30, 100, 25);

        ButtonGroup g = new ButtonGroup();
        g.add(cardOpt);
        g.add(upiOpt);

        add(cardOpt);
        add(upiOpt);

        add(new JLabel("Card:")).setBounds(50, 80, 60, 25);
        card = new JTextField();
        card.setBounds(120, 80, 200, 25);
        add(card);

        add(new JLabel("UPI:")).setBounds(50, 120, 60, 25);
        upi = new JTextField();
        upi.setBounds(120, 120, 200, 25);
        add(upi);

        JButton pay = new JButton("Pay");
        pay.setBounds(140, 170, 100, 30);
        pay.addActionListener(this);
        add(pay);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (cardOpt.isSelected()) {

            if (!card.getText().matches("\\d{6}")) {
                JOptionPane.showMessageDialog(this, "Invalid Card!");
                return;
            }

        } else if (upiOpt.isSelected()) {

            if (!upi.getText().contains("@")) {
                JOptionPane.showMessageDialog(this, "Invalid UPI!");
                return;
            }

        } else {
            JOptionPane.showMessageDialog(this, "Select payment method!");
            return;
        }

        bookings.add(new Booking1(name, from, to, seats));

        JOptionPane.showMessageDialog(this,
                "Payment Successful!\nSeats: " + seats);

        dispose();
    }
}


// ---------------- VIEW BOOKINGS ----------------
class ViewBookingsFrame1 extends JFrame {

    ViewBookingsFrame1(ArrayList<Booking1> bookings) {

        setTitle("Bookings");
        setSize(400, 300);

        String col[] = {"Name", "From", "To", "Seats"};
        String data[][] = new String[bookings.size()][4];

        for (int i = 0; i < bookings.size(); i++) {
            data[i][0] = bookings.get(i).name;
            data[i][1] = bookings.get(i).from;
            data[i][2] = bookings.get(i).to;
            data[i][3] = bookings.get(i).seats.toString();
        }

        JTable table = new JTable(data, col);
        add(new JScrollPane(table));

        setVisible(true);
    }
}

// ---------------- CANCEL ----------------
class CancelBookingFrame1 extends JFrame implements ActionListener {

    JTable table;
    ArrayList<Booking1> bookings;

    CancelBookingFrame1(ArrayList<Booking1> bookings) {

        this.bookings = bookings;
        setTitle("Cancel Booking");
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        String col[] = {"Name", "From", "To"};
        String data[][] = new String[bookings.size()][3];

        for (int i = 0; i < bookings.size(); i++) {
            data[i][0] = bookings.get(i).name;
            data[i][1] = bookings.get(i).from;
            data[i][2] = bookings.get(i).to;
        }

        table = new JTable(data, col);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton del = new JButton("Cancel");
        del.addActionListener(this);
        add(del, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();

        if (row != -1) {
            bookings.remove(row);
            JOptionPane.showMessageDialog(this, "Cancelled!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Select a booking first!");
        }
    }
}

// ---------------- MAIN ----------------
public class Manju {
    public static void main(String[] args) {
        new LoginPage1();
    }
}



