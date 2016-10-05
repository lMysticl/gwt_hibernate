package com.putrenkov.GWTHibernate.client.views;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;

public interface AppLayout {

    DockLayoutPanel getMainLayoutPanel();

    AcceptsOneWidget getMainConteiner();

}