package com.example.plugindev;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileListener;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import com.intellij.openapi.vfs.newvfs.events.VFilePropertyChangeEvent;
import org.jetbrains.android.dom.AndroidDomElement;
import org.jetbrains.android.dom.manifest.Manifest;
import org.jetbrains.android.util.AndroidUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class ManifestChangeListener implements BulkFileListener{

    @Override
    public void after(@NotNull List<? extends VFileEvent> events) {
        for (VFileEvent event : events) {
            if (Objects.requireNonNull(event.getFile()).getName().equals("AndroidManifest.xml")) {
                if (event instanceof VFilePropertyChangeEvent) {
                    // récupération de la propriété modifiée
                    String propertyName = ((VFilePropertyChangeEvent) event).getPropertyName();

                    // récupération de la valeur de la propriété avant la modification
                    Object oldValue = ((VFilePropertyChangeEvent) event).getOldValue();

                    // récupération de la valeur de la propriété après la modification
                    Object newValue = ((VFilePropertyChangeEvent) event).getNewValue();

                    // traitement de la modification
                    System.out.println("La propriété " + propertyName + " a été modifiée. Ancienne valeur : "
                            + oldValue + ". Nouvelle valeur : " + newValue + ".");
                } else {
                    // traitement de l'ajout ou de la suppression de contenu dans le fichier
                    System.out.println("Le fichier AndroidManifest.xml a été modifié.");
                    String contentBefore = getContentBefore(event);
                    String contentAfter = getContentAfter(event);
                    System.out.println("Contenu avant : " + contentBefore);
                    System.out.println("Contenu après : " + contentAfter);
                }
            }
        }
    }

    private String getContentBefore(VFileEvent event) {
        VirtualFile file = event.getFile();
        assert file != null;
        Document document = FileDocumentManager.getInstance().getDocument(file);
        assert document != null;
        CharSequence before = document.getImmutableCharSequence();
        return before.toString();
    }

    private String getContentAfter(VFileEvent event) {
        VirtualFile file = event.getFile();
        assert file != null;
        Document document = FileDocumentManager.getInstance().getDocument(file);
        CharSequence after = ((VFilePropertyChangeEvent) event).getNewValue().toString();
        return after.toString();
    }
}


    /*@Override
    public void documentChanged(DocumentEvent event) {
        VirtualFile file = event.getDocument();
        if (file == null || !"AndroidManifest.xml".equals(file.getName())) {
            return;
        }

        Manifest manifest = AndroidUtils.loadDomElement(project, file, Manifest.class);
        if (manifest != null) {
            Application.runWhenSmart(project, () -> {
                // Get all the application nodes in the manifest
                AndroidDomElement[] applicationElements = manifest.getApplicationElements();
                if (applicationElements == null || applicationElements.length == 0) {
                    return;
                }

                // Print the attributes of each application node
                Arrays.stream(applicationElements)
                        .flatMap(app -> app.getXmlTag().getAttributes().stream())
                        .forEach(attr -> System.out.println(attr.getName() + " : " + attr.getValue()));
            });
        }
    }

    @Override
    public void beforeDocumentChange(@NotNull DocumentEvent event) {
        // Do nothing
    }*/
