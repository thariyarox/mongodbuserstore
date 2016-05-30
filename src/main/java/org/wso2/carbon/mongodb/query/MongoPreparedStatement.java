package org.wso2.carbon.mongodb.query;

import java.util.ArrayList;
import java.util.Date;

import com.mongodb.*;
import org.bson.types.BSONTimestamp;
import org.bson.types.Binary;
import org.bson.types.Symbol;
import org.wso2.carbon.user.api.UserStoreException;

public interface MongoPreparedStatement {

	void setInt(String key, int parameter);
	
	void setDouble(String key, double parameter);
	
	void setString(String key, String parameter);
	
	void setTimeStamp(String key, BSONTimestamp timeStamp);
	
	void setArray(String key, ArrayList<Object> parameters);
	
	void setObject(String key, Object object);
	
	void setDate(String key, Date date);
	
	void setBoolean(String key, boolean parameter);
	
	void setDBPointer(String key, DBRef dbRef);
	
	void setSymbol(String key, Symbol symbol);
	
	void setRegularExpression(String key, String parameter);
	
	void setLong(String key, long parameter);

	void setBinary(String key, Binary stream);
	
	void close();
	
	WriteResult insert() throws MongoQueryException;
	
	DBCursor find() throws MongoQueryException;

	AggregationOutput aggregate() throws UserStoreException;

	WriteResult update() throws MongoQueryException;
	
	WriteResult update(boolean upsert, boolean multi) throws MongoQueryException;
	
	WriteResult update(boolean upsert, boolean multi, WriteConcern aWriteConcern) throws MongoQueryException;
	
	WriteResult update(boolean upsert, boolean multi, WriteConcern aWriteConcern, DBEncoder encoder) throws MongoQueryException;
	
	WriteResult update(boolean upsert, boolean multi, WriteConcern aWriteConcern, boolean byPassDocumentValidation, DBEncoder encoder) throws MongoQueryException;
	
	WriteResult updateMulti() throws MongoQueryException;
	
	WriteResult remove() throws MongoQueryException;
	
	WriteResult remove(WriteConcern concern) throws MongoQueryException;
	
	WriteResult remove(WriteConcern concern, DBEncoder encoder) throws MongoQueryException;

	BulkWriteResult insertBulk() throws MongoQueryException;

	BulkWriteResult updateBulk() throws MongoQueryException;

    void addBatch() throws MongoQueryException;

    void updateBatch() throws MongoQueryException;
}
