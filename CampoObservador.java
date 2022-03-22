package Campominadojogo;

@FunctionalInterface
public interface CampoObservador {

	public void ocorreuEvento(Campo campo, CampoEvento evento);
}
