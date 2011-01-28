/*
 * (C) Copyright 2011 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Julien Carsique
 *
 */

package org.nuxeo.launcher.gui.logs;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

/**
 * @author jcarsique
 * @since 5.4.1
 */
public class LogsHandler implements Observer {

    private JTextArea textArea;

    /**
     * @param nuxeoLauncherGUI
     */
    public LogsHandler(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            notifyLogsView((String) arg);
        }
    }

    /**
     * @param logLine Line read from log file being sent to view
     */
    public void notifyLogsView(String logLine) {
        textArea.append(logLine + System.getProperty("line.separator"));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

}
