package com.miqt.wand.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;

import com.miqt.wand.utils.R2;

/**
 * Created by miqt on 2019/2/19.
 * activity 代理器
 */

public abstract class ActivityProxy {

    public ProxyActivity mActy;

    public ActivityProxy(ProxyActivity acty) {
        mActy = acty;
    }

    public abstract void onCreate(@Nullable Bundle savedInstanceState);

    /**
     * 为什么要用这个方法?
     * <br><br/>
     * 主要用于解决主module模块R文件是用final修饰的，
     * 而用final修饰的对象在java中视为常量，在编辑成.class文件的时候，这个常量
     * 不会使用R.id.***的方式去引用而是直接是数字。因此这个值因为我们每次编译造成同一个id实际的id数字不一致，导致
     * findviewid找出来的view为空或者类型异常。
     * <p>
     * 至于不在主module模块引用的R文件，则无须使用这个方法,直接正常填写id即可
     * <br><br/>
     * 这个方法就是为了解决这个问题
     * <br><br/>
     * <p>
     * 方便起见，可以使用正则表达式批量替换代码
     * <br><br/>
     * 使用： <b>([^\(\),]*R\.[^\(\),]*)
     * <br><br/>
     * 替换：<b>$("$1")<b/>
     *
     * @param id 填“R.id.idname”格式一定要正确，最好是先用android的findviewbyid然后再加上双引号就好了
     */
    public int $(String id) {
        return R2.id_(id);
    }


    public void onStart() {
    }

    ;

    public void onResume() {
    }

    ;

    public void onRestart() {
    }

    ;

    public void onPause() {
    }

    ;

    public void onStop() {
    }

    ;

    public void onDestroy() {
    }

    ;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    ;

    public void onBackPressed() {
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    ;

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public void onNewIntent(Intent intent) {

    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }
}
