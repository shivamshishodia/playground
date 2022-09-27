-- Select a database
show dbs
use bookstore
show collections

-- Insert multiple nested documents
db.books.insertMany([
    {title: "The Color of Magic", author: "Terry", pages: 300, rating: 7, genres: ["fantasy", "magic"], reviews: [{name: "Yoshi", body: "Great"}, {name: "Buddy", body: "So so"}]},
    {title: "The Light Fantastic", author: "Terry", pages: 250, rating: 6, genres: ["fantasy"], reviews: [{name: "Brandon", body: "Good"}, {name: "Terry", body: "Awesome"}]},
    {title: "Dune", author: "Frank", pages: 500, rating: 10, genres: ["sci-fi", "dystopian"], reviews: [{name: "Mike", body: "Okay"}, {name: "Bianca", body: "Bad"}]},
    {title: "The Color of Magic", author: "Terry", pages: 300, rating: 7, genres: ["fantasy", "magic"], reviews: [{name: "Shana", body: "Average"}, {name: "Shaun", body: "Starrer"}]}
])

-- Operators are denoted by $. There are multiple operators in MongoDB
db.books.find({rating: {$gt: 7}}) -- $gt fetches all documents where rating is > 7
db.books.find({rating: {$lt: 7}}) -- $lt fetches all documents where rating is < 7
db.books.find({rating: {$gt: 5}, author: "Terry"})

-- OR operator
db.books.find({$or: [{rating: 7}, {rating: 9}]})
db.books.find({$or: [{rating: 7}, {author: "Terry"}]})
db.books.find({$or: [{pages: {$lt: 300}}, {pages: {$gt: 400}}]}) -- All documents having LESS THAN 300 OR GREATER THAN 400 pages

-- $in and $nin operator
db.books.find({rating: {$in: [7, 8, 9]}}) -- Ratings should be 7, 8, or 9
db.books.find({rating: {$nin: [7, 8, 9]}}) -- Ratings should NOT be 7, 8, or 9

-- Querying a basic nested array: genres: ["fantasy", "magic"]
db.books.find({genres: "magic"}) -- This will fetch all documents containing "magic" in genres.
db.books.find({genres: ["fantasy"]}) -- This will fetch all documents containing ONLY "fantasy" in genres.
db.books.find({genres: {$all: ["fantasy", "magic"]}}) -- This will fetch all documents containing "fantasy" and "magic" in genres. Others can also exist.

-- Querying a nested array: reviews: [{name: "Yoshi", body: "Great"}, {name: "Buddy", body: "So so"}]
db.books.find({"reviews.name": "Yoshi"}) -- Use . and ""
