//CRUD operation
const Author=require("../models/author.model")

module.exports.findAllAuthor =(req,res)=>
{
    Author.find()
    .then((allAuthors) => {
        res.json(allAuthors) // what it returns will be recieved in react
    })
    .catch(err => {
        res.json({ message: "Something went worng", serverError: err })
    })
}
module.exports.createAuthor =(request, response)=>
{
    console.log(request.body);
    Author.create(request.body)
        .then(newCreatedAuthor => {
            response.json(newCreatedAuthor )
        })
        .catch(err => response.status(400).json( err ))
}
module.exports.findOneAuthor =(req,res)=>
{
    Author.findOne({ _id: req.params.id })
.then(oneAuthor => {
    res.json(oneAuthor)
})
.catch(err => response.json({ message: 'Something went wrong', error: err }))
}
module.exports.updateExistingAuthor=(req,res)=>
{
    Author.findOneAndUpdate(
        { _id: req.params.id },
        req.body,
        { new: true, runValidators: true }
    )
        .then(updatedAuthor => res.json({ author: updatedAuthor }))
        .catch(err => res.status(400).json( err ));
}
module.exports.deletExistingAuthor=(req,res)=>
{
    Author.deleteOne({ _id: req.params.id })
    .then(result => res.json({ result: result }))
    .catch(err => res.status(400).json(err ));
}
// bokk
module.exports.addBokk=(req,res)=>{
    Author.findOneAndUpdate({_id:req.params.id},
        {$push:{books:req.body}},{
            new:true, runValidators:true
        }
        )
        .then((authors)=>res.json(authors))
        .catch(err => res.status(400).json(err));
}