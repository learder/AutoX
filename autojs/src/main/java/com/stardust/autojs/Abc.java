package com.stardust.autojs;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.nl.translate.TranslateRemoteModel;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;

import java.util.Set;

public class Abc {

    public void abc(){
        DownloadConditions dc=new DownloadConditions.Builder().requireCharging().build();
        Translation translation=null;
        Translator translator=Translation.getClient(null);
        translator.downloadModelIfNeeded();
        Task task=translator.translate("");
//        task.addOnFailureListener()
        translator.close();;
        RemoteModelManager modelManager = RemoteModelManager.getInstance();
        modelManager.getDownloadedModels(TranslateRemoteModel.class)
                .addOnSuccessListener(new OnSuccessListener<Set>() {
                    @Override
                    public void onSuccess(Set models) {
                        // ...
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Error.
                    }
                });
    }

}
