package com.itbt.assignment.tests;

import com.itbt.assignment.framework.FormPage;

public class SampleTest {
    public void fillFormAndSubmit() {
        String[] textInputValues = {"First Name, Muneiah",
        "Last Name, Pamujula",
        "E-Mail, muni.brejesh@gmail.com",
        "Phone #, 9440514246",
        "Address, 548 Market St",
        "City, New York",
        "Zip Code, 54043",
        "Website or domain name, http://www.google.com"};
        String[] textAreaInputValues = {"Project Description, First test program description"};
        String[] dropDownValues = {"State, New York"};
        String[] radioButtonValues = {"Do you have hosting?, No"};

        new FormPage().fillAllTextBoxes(textInputValues)
                .fillAllTextAreaBoxes(textAreaInputValues)
                .selectRadioButtons(radioButtonValues)
                .selectDropDownValues(dropDownValues)
                .clickOnButton("send");
    }

    public static void main(String arg[]){
        new SampleTest().fillFormAndSubmit();
    }
}
