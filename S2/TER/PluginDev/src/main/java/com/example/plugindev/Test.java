package com.example.plugindev;

import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileListener;
import com.intellij.openapi.vfs.VirtualFilePropertyEvent;
import org.jetbrains.annotations.NotNull;

public class Test implements DocumentListener {

    @Override
    public void propertyChanged(@NotNull VirtualFilePropertyEvent event) {

    }

    @Override
    public void contentsChanged(@NotNull VirtualFileEvent event) {
        if (event.getFileName().equals("AndroidManifest.xml")) {
            VirtualFile file = event.getFile();
        }
    }

    @Override
    public void beforeContentsChange(@NotNull VirtualFileEvent event) {
        VirtualFileListener.super.beforeContentsChange(event);
    }
}
