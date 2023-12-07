package com.muskan.creator;
import com.muskan.buttons.Button;
import com.muskan.buttons.HtmlButton;


public class HtmlDialog extends Dialog{
    @Override
    public Button createButton(){
        return new HtmlButton();
    }
}