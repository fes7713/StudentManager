package studentmanager.EntryForm;

import studentmanager.JavaClasses.Student;
import studentmanager.JavaClasses.Department;
import studentmanager.JavaClasses.Course;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.text.NumberFormatter;
import Repository.TestRepository;

public class StudentEntry{
    private JButton removeButton;
    private JPanel panel1;
    private JTextField firstNameEntry;
    private JTextField lastNameEntry;
    private JButton okButton;
    private JList<Course> searchCourseList;
    private JList<Course> studentCourseList;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JScrollPane searchCoursePane;
    private JScrollPane studentCoursePane;
    private JButton addButton;
    private JButton addAllButton;
    private JButton removeAllButton;
    private JLabel seachCourseLabel;
    private JLabel studentCourseLabel;
    private JFormattedTextField tuidEntry;
    private JComboBox<Department> departmentCmb;
    private JLabel departmentLabel;
    private JLabel tuidLabel;
    private JLabel majorLabel;
    private JTextField majorEntry;


    private DefaultListModel<Course> searchCourseModel;
    private DefaultListModel<Course> studentCourseModel;
    private DefaultComboBoxModel<Department> departmentModel;
    private boolean active;

    public StudentEntry() {
        active = true;
        
//         ok button behavior. by pressing this, window should close (WIP)
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "First Name :" + firstNameEntry.getText() + "\n" +
//                        "Last Name :" + lastNameEntry.getText());
//                firstNameEntry.setText("");
//                lastNameEntry.setText("");
                System.out.println(active);
                setActive(false);
                
            }
        });
        
        
        //Department Combobox
        departmentModel = new DefaultComboBoxModel<>();
        
        for(Department d :TestRepository.getDepartments())
        {
            departmentModel.addElement(d);
        }
        
        departmentCmb.setModel(departmentModel);
        departmentCmb.setSelectedIndex(0);

        // Course search list
        searchCourseModel = new DefaultListModel<>();
        
        for(Course c: TestRepository.getCourses())
        {
            searchCourseModel.addElement(c);
        }
       

        searchCourseList = new JList<>(searchCourseModel);
        searchCoursePane.getViewport().setView(searchCourseList);

        // Student course List
        studentCourseModel = new DefaultListModel<>();
        studentCourseList = new JList<Course>(studentCourseModel);
        studentCoursePane.getViewport().setView(studentCourseList);

        // Add button behavior
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                studentCourseList.clearSelection();
                if (!searchCourseList.isSelectionEmpty()) {
                    int[] indices = searchCourseList.getSelectedIndices();
                    for (int i = indices.length - 1; i >= 0; i--) {
                        Course removedItem = searchCourseModel.remove(indices[i]);
                        studentCourseModel.add(0, removedItem);
                        studentCourseList.setSelectedValue(studentCourseModel.get(0), true);
                    }

                    if (indices.length == 1) {
                        if (indices[0] >= searchCourseModel.getSize()) {
                            searchCourseList.setSelectedIndex(indices[0] - 1);
                            System.out.println(indices[0]);
                        } else {
                            searchCourseList.setSelectedIndex(indices[0]);
                            System.out.println(indices[0] + 1);
                        }
                    }
                }
            }
        });

        // Add All button behavior
        addAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = searchCourseModel.getSize();
                int verticalShit = studentCourseModel.getSize();
                for (int i = 0; i < size; i++) {
                    Course removedCourse = searchCourseModel.remove(0);
                    studentCourseModel.add(i + verticalShit, removedCourse);
                    studentCourseList.getSelectionModel().setSelectionInterval(verticalShit, studentCourseModel.getSize() - 1);
                }
            }
        });

        // remove button behaviour
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!studentCourseList.isSelectionEmpty()) {
                    int[] indices = studentCourseList.getSelectedIndices();
                    for (int i = indices.length - 1; i >= 0; i--) {
                        Course removedItem = studentCourseModel.remove(indices[i]);
                        searchCourseModel.add(0, removedItem);
                        searchCourseList.setSelectedValue(searchCourseModel.get(0), true);
                    }

                    if (indices.length == 1) {
                        if (indices[0] >= studentCourseModel.getSize()) {
                            searchCourseList.setSelectedIndex(indices[0] - 1);
                            System.out.println(indices[0]);
                        } else {
                            studentCourseList.setSelectedIndex(indices[0]);
                            System.out.println(indices[0] + 1);
                        }
                    }
                }
            }
        });
        
        // Remove all button behavior
        removeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = studentCourseModel.getSize();
                int verticalShit = searchCourseModel.getSize();
                for (int i = 0; i < size; i++) {
                    Course removedCourse = studentCourseModel.remove(0);
                    searchCourseModel.add(i + verticalShit, removedCourse);
                    searchCourseList.setSelectedValue(searchCourseModel.get(0), false);
                }
            }
        });
    }
   

    public JPanel getPanel1() {
        return panel1;
    }
    
    public boolean isActive()
    {
        return active;
    }
    
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public Student exec()
    {
        JFrame frame = new JFrame("Student Database Manager");
        frame.setSize(new Dimension(500, 300));
        frame.setContentPane(this.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        while(true)
        {
            try {
             Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            
            if(!isActive())
            {
                if(tuidEntry.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Empty TU ID is not allowed");
                    setActive(true);
                }
                else{
                    break;
                }
            }
        }
        frame.dispose();
        System.out.println("Ended");
        java.util.List<Course> courseList = new ArrayList<>();
        int maxIndex = studentCourseModel.getSize();
        for(int i = 0; i < maxIndex; i++)
        {
            courseList.add(studentCourseModel.getElementAt(i));
        }
        
        return new Student(new Integer(tuidEntry.getValue().toString()), firstNameEntry.getText(), lastNameEntry.getText(), majorEntry.getText(), (Department)departmentCmb.getSelectedItem(), courseList);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        Font panel1Font = this.$$$getFont$$$(null, -1, 16, panel1.getFont());
        if (panel1Font != null) panel1.setFont(panel1Font);
        panel1.setRequestFocusEnabled(false);
        lastNameEntry = new JTextField();
        lastNameEntry.setPreferredSize(new Dimension(250, 30));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(lastNameEntry, gbc);
        firstNameEntry = new JTextField();
        firstNameEntry.setPreferredSize(new Dimension(250, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(firstNameEntry, gbc);
        removeAllButton = new JButton();
        removeAllButton.setPreferredSize(new Dimension(100, 30));
        removeAllButton.setText("Remove All");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(removeAllButton, gbc);
        studentCoursePane = new JScrollPane();
        studentCoursePane.setPreferredSize(new Dimension(130, 150));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridheight = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 20, 0, 0);
        panel1.add(studentCoursePane, gbc);
        addButton = new JButton();
        addButton.setPreferredSize(new Dimension(100, 30));
        addButton.setText("Add");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(addButton, gbc);
        addAllButton = new JButton();
        addAllButton.setPreferredSize(new Dimension(100, 30));
        addAllButton.setText("Add All");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(addAllButton, gbc);
        removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(100, 30));
        removeButton.setText("Remove");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(removeButton, gbc);
        studentCourseLabel = new JLabel();
        Font studentCourseLabelFont = this.$$$getFont$$$(null, -1, 14, studentCourseLabel.getFont());
        if (studentCourseLabelFont != null) studentCourseLabel.setFont(studentCourseLabelFont);
        studentCourseLabel.setHorizontalAlignment(0);
        studentCourseLabel.setHorizontalTextPosition(0);
        studentCourseLabel.setPreferredSize(new Dimension(130, 22));
        studentCourseLabel.setText("Selected Courses");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(15, 20, 0, 0);
        panel1.add(studentCourseLabel, gbc);
        seachCourseLabel = new JLabel();
        Font seachCourseLabelFont = this.$$$getFont$$$(null, -1, 14, seachCourseLabel.getFont());
        if (seachCourseLabelFont != null) seachCourseLabel.setFont(seachCourseLabelFont);
        seachCourseLabel.setHorizontalAlignment(0);
        seachCourseLabel.setHorizontalTextPosition(0);
        seachCourseLabel.setPreferredSize(new Dimension(130, 22));
        seachCourseLabel.setText("Course List");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(15, 0, 0, 20);
        panel1.add(seachCourseLabel, gbc);
        searchCoursePane = new JScrollPane();
        searchCoursePane.setPreferredSize(new Dimension(130, 150));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridheight = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 20);
        panel1.add(searchCoursePane, gbc);
        lastNameLabel = new JLabel();
        Font lastNameLabelFont = this.$$$getFont$$$(null, -1, 14, lastNameLabel.getFont());
        if (lastNameLabelFont != null) lastNameLabel.setFont(lastNameLabelFont);
        lastNameLabel.setText("Last Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        panel1.add(lastNameLabel, gbc);
        firstNameLabel = new JLabel();
        Font firstNameLabelFont = this.$$$getFont$$$(null, -1, 14, firstNameLabel.getFont());
        if (firstNameLabelFont != null) firstNameLabel.setFont(firstNameLabelFont);
        firstNameLabel.setHorizontalAlignment(0);
        firstNameLabel.setHorizontalTextPosition(0);
        firstNameLabel.setText("First Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        panel1.add(firstNameLabel, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 25;
        panel1.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 25;
        panel1.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 15;
        panel1.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 15;
        panel1.add(spacer4, gbc);
        okButton = new JButton();
        okButton.setText("OK");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 20, 0, 0);
        panel1.add(okButton, gbc);
        
        // Accept only numbers here
        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Integer.class); //optional, ensures you will always get a long value
//        numberFormatter.setAllowsInvalid(false); //this is the key!!
//        numberFormatter.setMinimum(0l); //Optional
        tuidEntry = new JFormattedTextField(numberFormatter);
        tuidEntry.setPreferredSize(new Dimension(250, 30));
        
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(tuidEntry, gbc);
        tuidLabel = new JLabel();
        Font tuidLabelFont = this.$$$getFont$$$(null, -1, 14, tuidLabel.getFont());
        if (tuidLabelFont != null) tuidLabel.setFont(tuidLabelFont);
        tuidLabel.setHorizontalAlignment(0);
        tuidLabel.setHorizontalTextPosition(0);
        tuidLabel.setText("TU ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        panel1.add(tuidLabel, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 20;
        panel1.add(spacer5, gbc);
        departmentCmb = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        departmentCmb.setModel(defaultComboBoxModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(departmentCmb, gbc);
        departmentLabel = new JLabel();
        Font departmentLabelFont = this.$$$getFont$$$(null, -1, 14, departmentLabel.getFont());
        if (departmentLabelFont != null) departmentLabel.setFont(departmentLabelFont);
        departmentLabel.setText("Department");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        panel1.add(departmentLabel, gbc);
        majorLabel = new JLabel();
        Font majorLabelFont = this.$$$getFont$$$(null, -1, 14, majorLabel.getFont());
        if (majorLabelFont != null) majorLabel.setFont(majorLabelFont);
        majorLabel.setText("Major");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        panel1.add(majorLabel, gbc);
        majorEntry = new JTextField();
        majorEntry.setPreferredSize(new Dimension(250, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(majorEntry, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    

}
