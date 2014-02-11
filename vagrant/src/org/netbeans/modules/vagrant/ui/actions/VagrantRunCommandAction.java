/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2013 Sun Microsystems, Inc.
 */
package org.netbeans.modules.vagrant.ui.actions;

import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.netbeans.api.project.Project;
import org.netbeans.modules.vagrant.ui.RunCommandPanel;
import org.netbeans.modules.vagrant.utils.VagrantUtils;
import org.openide.DialogDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;

@ActionID(
        category = "Vagrant",
        id = "org.netbeans.modules.vagrant.ui.actions.VagrantRunCommandAction")
@ActionRegistration(
        displayName = "#CTL_VagrantRunCommandAction", lazy = false)
@NbBundle.Messages("CTL_VagrantRunCommandAction=Vagrant Run Command")
public class VagrantRunCommandAction extends VagrantAction {

    private static final long serialVersionUID = -4918272973110792497L;
    private static final Logger LOGGER = Logger.getLogger(VagrantRunCommandAction.class.getName());

    public VagrantRunCommandAction() {
        super(Bundle.CTL_VagrantRunCommandAction(), VagrantUtils.getIcon(VagrantUtils.RUN_COMMAND_ICON_16));
    }

    @Override
    public void actionPerformed(final Project project) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RunCommandPanel panel = RunCommandPanel.getDefault();
                DialogDescriptor descriptor = panel.showDialog(project);
                if (descriptor.getValue() == DialogDescriptor.OK_OPTION) {
                    panel.runCommand();
                }
            }
        });
    }
}
