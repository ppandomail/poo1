package ar.edu.uno.poo1.proyecto_tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayList {
	
	@Test
	public void testCrearPlayList() {
		PlayList playlist = new PlayList();
		playlist.agregar(new Cancion("unTitulo"));
		assertEquals(1, playlist.getCantidadCanciones());	
	}
	
	@Test
	public void testDuracionPlayList() {
		PlayList playlist =  new PlayList();
		playlist.agregar(new Cancion("unTitulo1", 4));
		playlist.agregar(new Cancion("unTitulo2", 2));
		playlist.agregar(new Cancion("unTitulo3", 5));
		assertEquals(11, playlist.getDuracion());
	}
	
	@Test
	public void testCancionMenorDuracion() {
		PlayList playlist =  new PlayList();
		playlist.agregar(new Cancion("unTitulo1", 4));
		playlist.agregar(new Cancion("unTitulo2", 2));
		playlist.agregar(new Cancion("unTitulo3", 5));
		assertEquals("unTitulo2", playlist.getTituloMenorDuracion());
	}
	
	@Test
	public void testBibliotecaConUnaPlayList() {
		Biblioteca biblioteca = new Biblioteca();
		PlayList playlist =  new PlayList();
		playlist.agregar(new Cancion("unTitulo1", 4));
		playlist.agregar(new Cancion("unTitulo2", 2));
		playlist.agregar(new Cancion("unTitulo3", 5));
		
		biblioteca.agregar(Genero.ROCK, playlist);
		assertEquals(1, biblioteca.getCantidadPlayList(Genero.ROCK));	
	}
	
	@Test
	public void testBibliotecaConDosPlayListGeneroDiferente() {
		Biblioteca biblioteca = new Biblioteca();
		PlayList playlistJazz =  new PlayList();
		playlistJazz.agregar(new Cancion("unTitulo1", 4));
		playlistJazz.agregar(new Cancion("unTitulo2", 2));
		playlistJazz.agregar(new Cancion("unTitulo3", 5));
		
		PlayList playlistRock =  new PlayList();
		playlistRock.agregar(new Cancion("unTitulo1", 4));
		
		biblioteca.agregar(Genero.JAZZ, playlistJazz);
		biblioteca.agregar(Genero.ROCK, playlistRock);
		assertEquals(1, biblioteca.getCantidadPlayList(Genero.JAZZ));
		assertEquals(1, biblioteca.getCantidadPlayList(Genero.ROCK));
	}
	
	@Test
	public void testBibliotecaConDosPlayListMismoGenero() {
		Biblioteca biblioteca = new Biblioteca();
		PlayList playlistJazz1 =  new PlayList();
		playlistJazz1.agregar(new Cancion("unTitulo1", 4));
		playlistJazz1.agregar(new Cancion("unTitulo2", 2));
		playlistJazz1.agregar(new Cancion("unTitulo3", 5));
		
		PlayList playlistJazz2 =  new PlayList();
		playlistJazz2.agregar(new Cancion("unTitulo1", 4));
		
		biblioteca.agregar(Genero.JAZZ, playlistJazz1);
		biblioteca.agregar(Genero.JAZZ, playlistJazz2);
		assertEquals(2, biblioteca.getCantidadPlayList(Genero.JAZZ));
	}

}