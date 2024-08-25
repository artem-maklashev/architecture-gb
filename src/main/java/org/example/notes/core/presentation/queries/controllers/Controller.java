package org.example.notes.core.presentation.queries.controllers;

import org.example.notes.core.presentation.queries.views.Presenter;

public abstract class Controller {
    public <T extends Presenter> void view(T presenter) {}
}
