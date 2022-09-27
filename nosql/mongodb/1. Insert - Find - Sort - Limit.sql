-- Select a database
show dbs
use bookstore
show collections

-- Insert document into collection
show collections

-- Insert one document
db.books.insertOne({title: "The Color of Magic", author: "Terry", pages: 300, rating: 7, genres: ["fantasy", "magic"]})
-- Output: {acknowledged: true, insertedId: ObjectId("63331f01725b15b0f27e66e9")}

-- Insert multiple documents. Note: It is an array.
db.books.insertMany([{title: "The Light Fantastic", author: "Terry", pages: 250, rating: 6, genres: ["fantasy"]}, {title: "Dune", author: "Frank", pages: 500, rating: 10, genres: ["sci-fi", "dystopian"]}])
-- Output: {acknowledged: true, insertedIds: {'0': ObjectId("633320e4725b15b0f27e66ea"), '1': ObjectId("633320e4725b15b0f27e66eb")}}

-- Finding documents
db.books.find() -- Prints first 20 documents
db.books.find({author: "Terry"}) -- Fetch author "Terry"
db.books.find({author: "Terry", rating: 7}) -- Fetch author "Terry" and rating 7
db.books.find({author: "Terry"}, {title: 1, author: 1}) -- Pass 2nd arguement. This will only return title and author associated with document
db.books.find({}, {title: 1, author: 1}) -- Select all documents but pass only title and author

db.books.findOne({_id: ObjectId("633320e4725b15b0f27e66ea")}) -- Find one document with a specific id

-- Limiting data
db.books.find().count()
db.books.find({author: "Terry"}).count()
db.books.find().limit(1)

-- Sorting data
db.books.find().sort({title: 1}) -- Ascending order via title
db.books.find().sort({title: -1}) -- Descending order via title
db.books.find().sort({title: -1}).limit(2) -- -- Descending order via title and limit it to 2
