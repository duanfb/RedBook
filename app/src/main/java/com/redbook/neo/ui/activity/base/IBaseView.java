package com.redbook.neo.ui.activity.base;

/**
 * @author : neo.duan
 * @date : 	 2016/6/20 0020
 * @desc : 所有View的操作基类
 */
public interface IBaseView {
    /**
     * show loading message
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * show error message
     */
    void showError(String msg);

    /**
     * show exception message
     */
    void showException(String msg);

    /**
     * show net error
     */
    void showNetError();
}

