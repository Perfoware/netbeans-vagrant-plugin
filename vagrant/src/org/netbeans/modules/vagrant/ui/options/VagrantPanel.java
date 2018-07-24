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
package org.netbeans.modules.vagrant.ui.options;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author junichi11
 */
final class VagrantPanel extends JPanel implements ChangeListener {

    private static final long serialVersionUID = -1753068861030271686L;
    private final VagrantOptionsPanelController controller;
    private final Map<String, VagrantCategoryPanel> categoryPanels = new HashMap<>();

    public VagrantPanel(VagrantOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        init();
    }

    private void init() {
        categoryList.setModel(new DefaultListModel<>());
    }

    public void addCategoryPanel(String name, VagrantCategoryPanel panel) {
        if (categoryPanels.containsKey(name)) {
            categoryList.setSelectedValue(name, true);
        } else {
            ((DefaultListModel<String>) categoryList.getModel()).addElement(name);
            categoryPanels.put(name, panel);
        }
    }

    public VagrantCategoryPanel getSelectedPanel() {
        String categoryName = categoryList.getSelectedValue();
        return categoryPanels.get(categoryName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryScrollPane = new javax.swing.JScrollPane();
        categoryList = new javax.swing.JList<String>();
        categoriesLabel = new javax.swing.JLabel();
        categoryPanel = new javax.swing.JPanel();

        categoryList.setMinimumSize(new java.awt.Dimension(150, 100));
        categoryList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                categoryListValueChanged(evt);
            }
        });
        categoryScrollPane.setViewportView(categoryList);

        org.openide.awt.Mnemonics.setLocalizedText(categoriesLabel, org.openide.util.NbBundle.getMessage(VagrantPanel.class, "VagrantPanel.categoriesLabel.text")); // NOI18N

        categoryPanel.setLayout(new javax.swing.BoxLayout(categoryPanel, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoriesLabel)
                    .addComponent(categoryScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoriesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void categoryListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_categoryListValueChanged
        String categoryName = categoryList.getSelectedValue();
        categoryPanel.setVisible(false);
        categoryPanel.removeAll();
        categoryPanel.add(categoryPanels.get(categoryName), BorderLayout.CENTER);
        categoryPanel.setVisible(true);
    }//GEN-LAST:event_categoryListValueChanged

    void load() {
        for (Map.Entry<String, VagrantCategoryPanel> entry : categoryPanels.entrySet()) {
            VagrantCategoryPanel vagrantCategoryPanel = entry.getValue();
            vagrantCategoryPanel.load();
        }
    }

    void store() {
        for (Map.Entry<String, VagrantCategoryPanel> entry : categoryPanels.entrySet()) {
            VagrantCategoryPanel vagrantCategoryPanel = entry.getValue();
            vagrantCategoryPanel.store();
        }
    }

    boolean valid() {
        for (Map.Entry<String, VagrantCategoryPanel> entry : categoryPanels.entrySet()) {
            VagrantCategoryPanel vagrantCategoryPanel = entry.getValue();
            boolean valid = vagrantCategoryPanel.valid();
            if (!valid) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        for (Map.Entry<String, VagrantCategoryPanel> entry : categoryPanels.entrySet()) {
            VagrantCategoryPanel vagrantCategoryPanel = entry.getValue();
            vagrantCategoryPanel.reload();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoriesLabel;
    private javax.swing.JList<String> categoryList;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JScrollPane categoryScrollPane;
    // End of variables declaration//GEN-END:variables
}
