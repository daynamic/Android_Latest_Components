package com.raywenderlich.reposearch;

import java.util.ArrayList;

/**
 * Created by asharm93 on 5/13/17.
 */

public interface DownloadCompleteListener {

    void downloadComplete(ArrayList<Repository> repositories);
}
