export function Input ({texte, inc, numero, id}) {
    return <input className="form-control" type="text" key={`li${inc}${numero}`} defaultValue={texte} id={id} />
}