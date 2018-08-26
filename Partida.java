package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Partida {

	private BolsaDeTiles tiles;
	private Tile proximoTile;
	private int contadorDeTurno;
	private boolean status;
	private boolean pecaAtualJaPosicionada;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("  ");

	Partida(BolsaDeTiles tiles) {
		this.tiles = tiles;
		pegarProximoTile();
	}
	
	public String relatorioPartida(String status, String sequencia) {
		return "Status: " + status + "\nJogadores: " + sequencia;
	}

	public String relatorioTurno(String jogador, String tile, String status) {
		if(this.status) {
			throw new ExcecaoJogo("Partida_Finalizada");
		}
		return "Jogador: " + jogador + "\nTile: " + tile + "\nStatus: " + status;
	}
	
	public String relatorioTurno() {
		if(this.status) {
			throw new ExcecaoJogo("Partida_Finalizada");
		}
		return null;
	}

		public Partida girarTile() {
			if(pecaAtualJaPosicionada) {
				throw new ExcecaoJogo("Não pode girar tile já posicionado");
			}
			if(contadorDeTurno == 1) { 
				throw new ExcecaoJogo("Não pode girar tile já posicionado");
			}
		proximoTile.girar();
		return this;
	}

	private void pegarProximoTile() {
		contadorDeTurno ++;
		proximoTile = tiles.pegar();
		if(proximoTile != null) {
			proximoTile.reset();
		}else {
			status = true;
		}
	}

	public Partida finalizarTurno() {
		pegarProximoTile();
		return this;
	}

	public Partida posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		return this;
	}

	public Partida posicionarMeepleEstrada(Lado lado) {
		return this;
	}

	public Partida posicionarMeepleCampo(Vertice vertice) {
		return this;
	}

	public Partida posicionarMeepleCidade(Lado lado) {
		return this;
	}

	public Partida posicionarMeepleMosteiro() {
		return this;
	}

	public String getEstradas() {
		return null;
	}

	public String getCampos() {
		return null;
	}

	public String getCidades() {
		return null;
	}

	public String getMosteiros() {
		return null;
	}

	public String relatorioTabuleiro(String configuracao) {
		return configuracao;
	}
}
//