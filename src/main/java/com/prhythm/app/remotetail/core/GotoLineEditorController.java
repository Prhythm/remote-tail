package com.prhythm.app.remotetail.core;

import com.prhythm.core.generic.util.Strings;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * 顯示到指定行的視窗
 * Created by nanashi07 on 16/1/4.
 */
public class GotoLineEditorController implements IFocusable {

    @FXML
    TextField lineNumber;

    /**
     * 取得輸入的行數
     *
     * @return
     */
    public Integer selectedLineNumber() {
        if (Strings.isNullOrWhiteSpace(lineNumber.getText())) return null;
        try {
            int value = Integer.parseInt(lineNumber.getText().trim());
            return value > 0 ? value : null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void focus() {
        Platform.runLater(lineNumber::requestFocus);
    }

}
