package com.muskan.creator;
import com.muskan.buttons.Button;
import com.muskan.buttons.WindowsButton;


public class WindowsDialog extends Dialog{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }
}