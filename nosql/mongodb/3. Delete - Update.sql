-- Delete documents
db.books.find()
db.books.deleteOne({_id: ObjectId("63332ad7725b15b0f27e66ef")})
-- Output: { acknowledged: true, deletedCount: 1 }

-- Update document. Use $set operator.
db.books.updateOne({_id: ObjectId("63332ad7725b15b0f27e66ee")}, {$set: {rating: 8, pages: 360}})

-- $inc operator
db.books.updateOne({_id: ObjectId("63332ad7725b15b0f27e66ee")}, {$inc: {pages: 2}})
db.books.updateOne({_id: ObjectId("63332ad7725b15b0f27e66ee")}, {$inc: {pages: -2}})

-- Add/Remove element from nested array. $push/$pull operator.
db.books.updateOne({_id: ObjectId("63332ad7725b15b0f27e66ee")}, {$pull: {genres: "sci-fi"}})
db.books.updateOne({_id: ObjectId("63332ad7725b15b0f27e66ee")}, {$push: {genres: "sci-fi"}})

-- Add/Remove multiple elements in nested array. $each operator
db.books.updateOne({_id: ObjectId("63332ad7725b15b0f27e66ee")}, {$push: {genres: {$each: ["1", "2"]}}})
