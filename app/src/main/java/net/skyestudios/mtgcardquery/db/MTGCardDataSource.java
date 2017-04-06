package net.skyestudios.mtgcardquery.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import net.skyestudios.mtgcardquery.data.Card;

/**
 * Created by arkeonet64 on 4/4/2017.
 */

public class MTGCardDataSource {
    private SQLiteDatabase database;
    private MTGCardSQLiteHelper databaseHelper;

    public MTGCardDataSource(Context context) {
        databaseHelper = new MTGCardSQLiteHelper(context);
    }

    public void openDb() {
        database = databaseHelper.getWritableDatabase();
    }

    public void closeDb() {
        database.close();
    }

    public void createCard(Card card) {
        ContentValues values = new ContentValues();

        //TODO: Finish adding card properties to database
        values.put(MTGCardSQLiteHelper.CardColumns.name.toString(), card.getName());
        values.put(MTGCardSQLiteHelper.CardColumns.layout.toString(), card.getLayout());
        values.put(MTGCardSQLiteHelper.CardColumns.cmc.toString(), card.getCmc());
        values.put(MTGCardSQLiteHelper.CardColumns.manaCost.toString(), card.getManaCost());
        values.put(MTGCardSQLiteHelper.CardColumns.colors.toString(), card.getColors());
        values.put(MTGCardSQLiteHelper.CardColumns.type.toString(), card.getType());
        values.put(MTGCardSQLiteHelper.CardColumns.types.toString(), card.getTypes());
        values.put(MTGCardSQLiteHelper.CardColumns.subtypes.toString(), card.getSubtypes());
        values.put(MTGCardSQLiteHelper.CardColumns.text.toString(), card.getText());
        values.put(MTGCardSQLiteHelper.CardColumns.power.toString(), card.getPower());
        values.put(MTGCardSQLiteHelper.CardColumns.toughness.toString(), card.getToughness());
        values.put(MTGCardSQLiteHelper.CardColumns.imageName.toString(), card.getImageName());
        values.put(MTGCardSQLiteHelper.CardColumns.printings.toString(), card.getPrintings());
        values.put(MTGCardSQLiteHelper.CardColumns.source.toString(), card.getSource());
        values.put(MTGCardSQLiteHelper.CardColumns.rulings.toString(), card.getRulings());
        values.put(MTGCardSQLiteHelper.CardColumns.colorIdentity.toString(), card.getColorIdentity());
        values.put(MTGCardSQLiteHelper.CardColumns.legalities.toString(), card.getLegalities());
        values.put(MTGCardSQLiteHelper.CardColumns.supertypes.toString(), card.getSupertypes());
        values.put(MTGCardSQLiteHelper.CardColumns.starter.toString(), card.getStarter());
        values.put(MTGCardSQLiteHelper.CardColumns.loyalty.toString(), card.getLoyalty());
        values.put(MTGCardSQLiteHelper.CardColumns.hand.toString(), card.getHand());
        values.put(MTGCardSQLiteHelper.CardColumns.life.toString(), card.getLife());
        values.put(MTGCardSQLiteHelper.CardColumns.names.toString(), card.getNames());

        database.insert(MTGCardSQLiteHelper.TABLE_NAME, null, values);
    }
}