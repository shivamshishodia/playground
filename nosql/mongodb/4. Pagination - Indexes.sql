-- Pagination: Skip first two documents and show the next document (third in order)
db.books.find().skip(2).limit(1)

-- Indexes
-- Examine the query and look for `executionStats.nReturned` and `executionStats.totalDocsExamined`
db.books.find({rating: 8}).explain('executionStats')
-- You do not have to examine all the documents. For the above query, all 3 documents were examined to find one document.
db.books.createIndex({rating: 8})
-- Now only 1 document was examined to get the data. Check `executionStats.nReturned` and `executionStats.totalDocsExamined` again.
db.books.find({rating: 8}).explain('executionStats')

-- Fetch all indexes
db.books.getIndexes()
/* Output:
    [
      { v: 2, key: { _id: 1 }, name: '_id_' },
      { v: 2, key: { rating: 8 }, name: 'rating_8' }
    ]
*/

-- Drop indexes
db.books.dropIndex({rating: 8})
-- Output: { nIndexesWas: 2, ok: 1 }
