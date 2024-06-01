package br.edu.utfpr.avaliacaomusical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import br.edu.utfpr.avaliacaomusical.classes.Album;

public class AlbumAdapter extends BaseAdapter {
    private final Context context;
    private final List<Album> albuns;

    private static class AlbumHolder {
        public TextView textViewNomeAlbum;
        public TextView textViewNomeArtista;
        public TextView textViewDataLancamento;
        public RatingBar ratingBarClassificacao;
    }

    public AlbumAdapter(Context context, List<Album> albuns) {
        this.context = context;
        this.albuns = albuns;
    }

    @Override
    public int getCount() {
        return albuns.size();
    }

    @Override
    public Object getItem(int position) {
        return albuns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlbumHolder holder;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );

            convertView = inflater.inflate(R.layout.linha_listagem_albuns, parent, false);

            holder = new AlbumHolder();

            holder.textViewNomeAlbum = convertView.findViewById(R.id.textViewNomeAlbum);
            holder.textViewNomeArtista = convertView.findViewById(R.id.textViewNomeArtista);
            holder.textViewDataLancamento = convertView.findViewById(R.id.textViewDataLancamento);
            holder.ratingBarClassificacao = convertView.findViewById(R.id.ratingBarClassificacao);

            convertView.setTag(holder);

        } else {

            holder = (AlbumHolder) convertView.getTag();
        }

        holder.textViewNomeAlbum.setText(albuns.get(position).getNome());
        holder.textViewNomeArtista.setText(albuns.get(position).getArtista());
        holder.textViewDataLancamento.setText(albuns.get(position).getDataLancamento());
        holder.ratingBarClassificacao.setRating(albuns.get(position).getClassificacao());

        return convertView;
    }
}
